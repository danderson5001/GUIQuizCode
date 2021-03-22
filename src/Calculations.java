import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JTextArea;

public class Calculations extends AbstractPerson {
	
	Random rand = new Random();
	String choicePerson1;
	String choicePerson2;
	//Constructors
	public Calculations() {
	}//end of Calculations method
	
	public void setChoicePerson1(Scanner scan, JTextArea textArea) {
		textArea.append("Please enter the first person's name");
    	choicePerson1 = scan.nextLine(); 
	}

	public void setChoicePerson2(Scanner scan, JTextArea textArea) {
		textArea.append("Please enter the Second person's name");
    	choicePerson2 = scan.nextLine(); 
	}

	//getters and setters
	public String getName() {
		return name;
	}//end of getName

	public int getCount() {
		return count;
	}//end of getCount()
	
	public int getFileArray() {
		
		return myFileReaderArray.length;
	}
	
	//Major Methods
	//creates files and scanners for reading
	public void numPeopleMethod(int numPeople, int personIndex) throws FileNotFoundException {
		//System.out.println(numPeople + " = numpeople " + personIndex +" = personIndex");
		myFileReaderArray = new File[numPeople];
		scanFileArray = new Scanner[numPeople];
		String nameFile = "Person" + String.valueOf(personIndex) +".txt";
		myFileReaderArray[personIndex] = new File(nameFile);
		scanFileArray[personIndex] = new Scanner (myFileReaderArray[personIndex]);
	}//end of method numPeopleMethod

	public void fillArray(String name, int personIndex) {
		for(int indexing = 0; scanFileArray[personIndex].hasNext(); indexing++) {
			everyoneArray[personIndex][indexing] = scanFileArray[personIndex].next();
		}//end of while in file
		namesArray[personIndex] = name;
	}//end of fill files method
	
	public void deleteBoring(int personIndex) {
		for(int i =0; i <everyoneArray.length; i++) {
			for(int j =0; j< everyoneArray[personIndex].length; j++) {
				for(int k =0; k< contentsSub.length; k++) {
					if(everyoneArray[i][j].equals(contentsSub[k])) {
						double chaos = (double)((((rand.nextDouble()*1000) 
								+ rand.nextDouble()*100) + rand.nextDouble()+1));
						everyoneArray[i][j] = String.valueOf(chaos);
					}//if to check if word==boring
				}//for loop for scrolling through boring words
			}//for loop for scrolling through the words of the each person
		}//for loop for scrolling through the rows of the everyoneArray going through each person
	}//end of deleteBoring
	
	public boolean CrossReference() {
		int i;
		int choicePerson1Index = -1;
		int choicePerson2Index = -1;
		
		for(i =0; i<= namesArray.length; i++) {
			if(i<namesArray.length) {
				if(namesArray[i]==choicePerson1){
					choicePerson1Index = i;
				} else if(namesArray[i]==choicePerson2){
					choicePerson2Index = i;
				}//end of check if index of person
				if((choicePerson1Index != -1) && (choicePerson2Index != -1)) {
					break;
				}//end if check if both people were indexed
			}else {
				return false;
			}//end of for that checks if a not real name was entered
		}//end of for that goes through namesArray
		for(int j =0; j< everyoneArray[choicePerson1Index].length; j++) {
			for(int k=0; k< everyoneArray[choicePerson2Index].length; k++) {
				if(everyoneArray[choicePerson1Index][j]== everyoneArray[choicePerson2Index][k]) {
					score++;
				}
			}
		}
		return true;
	}//end of crossReference method
	
}//end of class

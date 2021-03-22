import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JTextArea;

public class Person extends AbstractPerson{
	
	//variables
	public String perfectDate = "x", dinner = "x", 
			dwarf = "x", color = "x", pet = "x", princess = "x";

	/**
	 * Constructor
	 * 
	 * {@summary} the default constructor instantiates the variables 
	 * but all my variables are set by the user, so this is just here out of principle,
	 *  a default constructor with no contents
	 * */
	public Person() {
	}
	
	//Getters and Setters
	public String getName() {
		return name;
	}//end of getName\
	
	
	public void setName(Scanner scan, JTextArea textArea, int count) {
		textArea.append("Please enter your name");
    	name = scan.nextLine(); 
    	count ++;
	}//end of setName
	
	public int getCount() {
		return count;
	}//end of getCount
	
	//Major Functions
	public void numPeopleMethod(int numPeople, int personIndex) throws FileNotFoundException {
		myFileWriterArray = new PrintWriter[numPeople];
		String printWriterName = "personFile" +String.valueOf(personIndex);
		PrintWriter PrintWriterName = new PrintWriter("Person"+personIndex+".txt");
		myFileWriterArray[personIndex] = PrintWriterName;
	}//end of numPeopleMethod
	
	public boolean startFunction(Scanner scan, JTextArea textArea) {
		//variables
		String start = "";
		boolean ifStart = false;
		//scan in if they are ready to begin
		
		textArea.append("Hello. Welcome to The cupidQuiz. " + "Press a to begin.");
		System.out.println("after append");
		start = scan.nextLine();
		
		System.out.println("After append");
		if(start.compareToIgnoreCase("start") == 0) {
			ifStart = true;
		}
		count++;
		return ifStart;
	}
	
	public void nextQuestion(int count, Scanner scan, JTextArea textArea) {
		while(count < 9)
		if(count==2){
        	textArea.append(basicQuestion[0]);
 			perfectDate = scan.nextLine();
 			textArea.append(perfectDate);
 			answersArray[0] = perfectDate.toLowerCase();
        	count++;
         } else if(count==3){
        	textArea.append(basicQuestion[1]);
 			dinner = scan.nextLine();
 			textArea.append(dinner);
 			answersArray[1] = dinner.toLowerCase();
        	count++;
         } else if(count==4){
        	textArea.append(basicQuestion[2]);
 			dwarf = scan.nextLine();
 			textArea.append(dwarf);
 			answersArray[2] = dwarf.toLowerCase();
        	count++;
         } else if(count==5){
        	textArea.append(basicQuestion[3]);
 			color = scan.nextLine();
 			textArea.append(color);
 			answersArray[3] = color.toLowerCase();
        	count++;
         } else if(count==6){
        	textArea.append(basicQuestion[4]);
 			pet = scan.nextLine();
 			textArea.append(pet);
 			answersArray[4] = pet.toLowerCase();
        	count++;
         } else if(count==7){
        	textArea.append(basicQuestion[5]);
 			princess = scan.nextLine();
 			textArea.append(princess);
 			answersArray[5] = princess.toLowerCase();
        	count++;
         } else if(count==8){
        	textArea.append("Please pass the device to the next player");
         }//end of if-else asking the question
	}//end of nextQuestion
	
	public void addToFile(int numPeople, int personIndex) {
		for(int i=0; i < basicQuestion.length; i++) {
			myFileWriterArray[personIndex].println(answersArray[i]);
		}
	}
}//end of class

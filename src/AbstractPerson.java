import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JTextArea;

public abstract class AbstractPerson {
	
	//Variables
	protected String name = "default";
	protected int count =0 ;
	protected int score = 0;
	
	//Consistent arrays
	//array for boring words
	String[] contentsSub = { "the", "i", "go", "would", "for", "my", "favorite", " is ", "color", "animal",
			"perfect", "date", "be", "then", "going", "a", "and", "or", "in", "want", "to", "maybe",
			"at", "with", "side", "of", "get", "like", "on", "eat", "some", ".", ",", "s", "say", "eating",
			"i", "ed" };
	//array for persons answers
	String[] answersArray = new String[7];
	//array for storing the names of files for writing
	PrintWriter[] myFileWriterArray;
	//array for storing the names of files for reading
	File[] myFileReaderArray;
	//array to store the names of Scanners for files for reading
	Scanner[] scanFileArray;
	//array containing the names of each person
	String[] namesArray;
	//2-D array for putting all of the people
	String[][] everyoneArray;
	//Array filled with questions
	String[] basicQuestion = {"What is your perfect date?", "What is your perfect dinner? ",
		"What is your favorite dwarf from snow white?", "What is your favorite color?", 
		"What is your favorite animal?", "What is your favorite disney princess?"};
	
	//abstract Methods
	public abstract String getName();
	public abstract int getCount();
	public abstract void numPeopleMethod(int numPeople, int personIndex) throws FileNotFoundException;
	
	//Only in Person
//	public void setName(Scanner scan, JTextArea textArea, int count)
//	public abstract boolean startFunction(Scanner scan, JTextArea textArea);
//	public abstract void nextQuestion(int count, Scanner scan, JTextArea textArea);
	
	
}

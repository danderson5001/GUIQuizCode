/*
 * @author
 * @date 
 * @class Main this class will contain all the information for writing a GUI,
 * 		this will also contain main, and references to all other objects that will be 
 * 		created based on other classes.
 * @class AbstractPerson is the outline for our person and calculator and lays out what
 *		needs to be done in the other methods
 * @class Person1
 * @class Calculator 
 * Known Bugs: 
 * 		- Something wrong with driver, it wants me to make it abstract and inherit AbstractPerson
 * 		- add to file in Person doesn't do what its supposed to, easy fix but its late
 * */

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Driver implements ActionListener{
	
	static JTextArea textArea;
	static JButton button;
	
	static int numPeople = 2;
	static int personIndex = 0;
	static Person[] personArray = new Person[numPeople];
	 
	public static void main(String[]args) throws FileNotFoundException {
		//----------------------------------------------------------------------------------
		/**
		 * GUI set Up
		 * - the very basic outline of the GUI was inspired by stack overflow.
		 * */
		JFrame frame = new JFrame("Quiz Pop-up");
		frame.setSize(600, 450);
		frame.setLocation(400,200);
		textArea = new JTextArea(100, 200);
		textArea.append("Please answer every question in a complete sentence.");
		frame.getContentPane().add(BorderLayout.CENTER, textArea);
		button = new JButton("Begin");
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		button.setSize(100,100);

		//------------------------------------------------------------------------------------------
		//Create Scanner 
		 Scanner scan = new Scanner(System.in);
	
		
		 Calculations calculatorMain = new Calculations();
		 //create Objects
		 for(int i =0; i< numPeople; i++, personIndex++) {
			 Person player = new Person();
			 personArray[i] = player;			 
			 Calculations calculator = new Calculations();
			 
			 //Do Stuff with Objects
			 player.numPeopleMethod(numPeople, personIndex);
			 calculator.numPeopleMethod(numPeople, personIndex);
			 
			 //begins the game and sets their name
			 System.out.println("before player.start");
			 player.startFunction(scan, textArea);
			 System.out.println("after player.start");
			 if(player.startFunction(scan, textArea)) {
				 player.setName(scan, textArea, player.getCount());
			 }//end of beginning Game and Setting name
			 player.addToFile(numPeople, personIndex);
			 
			 calculator.fillArray(player.getName(), personIndex);
			//----------------------------------------------------------------------------------------
	
			 // Action Listener
			 button.addActionListener(new ActionListener() {	
		
			@Override
			public void actionPerformed(ActionEvent e) {
				//player.nextQuestion(player.getCount(), scan, textArea);
			}
		});//end of add listener 
		}//end of for loop for each person
		calculatorMain.deleteBoring(personIndex);
		calculatorMain.setChoicePerson1(scan, textArea);
		calculatorMain.setChoicePerson2(scan, textArea);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}//end of class

package question2;
//Regan Ross, 0369345
//For Dr.Aaron Langille, master of ye olde Turing Machine
//Assignment 3, Question 2
import java.util.Scanner;
import java.io.*;
import javax.swing.*;

public class Sum2 {

	public static void main(String[] args) {
		/*
		Scanner keyb = new Scanner(System.in);
		
		System.out.print("Enter an input file: ");
		String input = keyb.nextLine();
		System.out.print("\nEnter an output file: ");
		String output = keyb.nextLine();
		
		*/
		
		try {
			JFileChooser chooser = new JFileChooser();
			chooser.showOpenDialog(null);
			
			String input = chooser.getSelectedFile().toString();
			chooser.showOpenDialog(null);
			String output = chooser.getSelectedFile().toString();

			
			Scanner fIn = new Scanner(new File(input));
			PrintWriter fOut = new PrintWriter(new File(output));
			
			while(fIn.hasNextLine()) {
				String line = fIn.nextLine();
				String[] temp = line.split(":");
				
				try {
				double one = Double.parseDouble(temp[0]);
				double two = Double.parseDouble(temp[1]);
				double sum = one + two;
				double avg = sum / 2;
				
				fOut.println(sum + " " + avg);
				}
				catch(NumberFormatException e) {
					fOut.println("Error converting numbers");
					}
				catch(ArrayIndexOutOfBoundsException f) {
					fOut.println("Missing Column");
				}
				/*double one = fIn.nextDouble();
				double two = fIn.nextDouble();
				System.out.println(fIn.nextDouble());
				double sum = one + two;
				
				fOut.println(sum);
				
				*/
			
			}
			
			fIn.close();
			fOut.close();			
			
			
		}catch(FileNotFoundException e) {
			System.out.println("File not found.");
		}
		
		System.out.println("Program Complete.");
	}

}

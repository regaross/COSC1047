//Regan Ross , 0369345
//for Dr. Aaron Langille , Master of ye olde Turing Machine
//Assignment 3 / Question 1

package question1;
import java.util.Scanner;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class FileStats2 {

	public static void main(String[] args) {
		
		int numLines = 0;
		int numWords = 0;
		int numChars = 0;
		int wordCount = 0;
		int myWord = 0;
		String splitter = "[ ]+";
		String Line;
		String Word = "";
		
		Scanner keyboard = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		
		
		
			try {
				
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				System.out.println("Enter a word to search for: ");
				Word = keyboard.nextLine();
				
				String fileName = chooser.getSelectedFile().toString();
				Scanner fIn = new Scanner(new File (fileName));
			
				while(fIn.hasNextLine()) {
				
				Line = fIn.nextLine();		
				
				numLines++;
				
				String[] Words = Line.split(splitter);
				numChars += Line.length();
				myWord = 0;
					
					for(int i = 0; i < Words.length; i++) {
						if(Words[i].equalsIgnoreCase(Word)) {
							wordCount++;
							myWord++;
						}
						if(!Words[i].isEmpty())
							numWords++;
						
					}
					if(myWord > 0)
						list.add((numLines) + ": " + Line);
				}
			
				fIn.close();
				
			
			}catch(FileNotFoundException e){
				System.out.println("File not found. Program done.");
			}
		
			
			System.out.println("Lines: " + numLines);
			System.out.println("Words: " + numWords);
			System.out.println("Characters: " + numChars);
			
			System.out.println("Your word - " + Word + " - was found " + wordCount + " times.");
			
			for(int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		
		
		
	}

}

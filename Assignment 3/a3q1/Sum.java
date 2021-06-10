package question1;

import java.util.Scanner;
import java.io.*;

public class Sum {

	public static void main(String[] args) {
		
		
		try {
			
			
			Scanner fIn = new Scanner(new File("numbers.txt"));
			PrintWriter fOut = new PrintWriter(new File("output.txt"));
			
			while(fIn.hasNextDouble()) {
				System.out.println(fIn.nextDouble());
				
				double one = fIn.nextDouble();
				double two = fIn.nextDouble();
				
				double sum = one + two;
				
				fOut.println(sum);
			
			}
			
			fIn.close();
			fOut.close();			
			
			
		}catch(FileNotFoundException e) {
			
			
		}

	}

}

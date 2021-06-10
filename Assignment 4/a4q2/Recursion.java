//Regan Ross, 0369345
//Assignment 4 question 2
//for Dr. Aaron Langille, wearer of aviation shades


package question2;

import java.util.Scanner;

public class Recursion {

	public static void main(String[] args) {
	
		Scanner keyb = new Scanner(System.in);
		
		//Method 1
		System.out.print("Enter two numbers, base then exponent");
		int x = keyb.nextInt();
		int y = keyb.nextInt();
		keyb.nextLine();
		System.out.println("Result: " + pow(x,y));
		System.out.println();
		
		//Method 2
		System.out.println("Enter a String to reverse");
		String word = keyb.nextLine();
		String reversed = revStr(word);	
		System.out.println("Result: " + reversed);
		System.out.println();
		
		//Method 3
		System.out.println("Enter an integer to count the digits: ");
		x = keyb.nextInt();
		keyb.hasNextLine();
		
		y = digCount(x);
		
		System.out.println("Result: " + y);
		
	}

	//Recursive method a 
	public static int pow(int a, int n) {
		
		if(n == 0)
			return 1;
		if(n == 1)
			return a;
		else {
			return a*(pow(a,(n-1)));
		}
	}
	//Recursive String method
	public static String revStr(String s) {
		//base case
		if(s.isEmpty())
			return s;
		
		else
			return revStr(s.substring(1)) + s.charAt(0);
		
	}	
	//Recursive method c
	public static int digCount(int i) {
		i = Math.abs(i); //just in case
	
		//base case
		if(i<10)
			return 1;
		else {
			
			return 1 + digCount((int)(i/10));
		}
			
		
		
	}
}

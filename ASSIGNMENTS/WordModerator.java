package com.Assignments;
import java.util.Scanner;

public class WordModerator {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String[] list = {"bad","negative","wrong","scam","hacker"};
		System.out.print("Enter a word or type \\\"end\\\" to end the program : ");
		String word = scan.next();			
		for(int i=0;i<list.length;i++) {
			if(word.equalsIgnoreCase(list[i])) {
				System.out.println("You typed " + word + "which is censor word");
				break;
			}
			else {
				System.out.println("You typed " + word + "!");
				break;
			}
		}
	System.out.println("Program ended!");
	}
}
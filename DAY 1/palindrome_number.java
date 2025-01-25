package com.day1;

import java.util.Scanner;

public class palindrome_number {

	public static void main(String[] args) {
		Scanner myobj = new Scanner(System.in);
        int n = myobj.nextInt();
        int temp=n;
        int sum=0;
        while(n>0) {
        	int rem = n%10;
        	sum=(sum*10)+rem;
        	n=n/10;
        }
        if(temp==sum) {
        	System.out.println(temp+" is a palindrome number");
        }
        else {
        	System.out.println(temp+" is not a palindrome number");
        }
	}

}

package com.day1;

import java.util.Scanner;

public class pyramid_numbers {

	public static void main(String[] args) {
		Scanner myobj = new Scanner(System.in);
        int n = myobj.nextInt();
        for(int row=1;row<n+1;row++) {
        	for(int col1=n;col1>row;col1--) {
        		System.out.print(" ");
        	}
        	for(int col2=1;col2<row+1;col2++) {
        		System.out.print(row+" ");
        	}        		
        	System.out.println();
        }

	}

}

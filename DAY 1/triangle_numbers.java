package com.day1;

import java.util.Scanner;

public class triangle_numbers {

	public static void main(String[] args) {
		Scanner myobj = new Scanner(System.in);
        int n = myobj.nextInt();
        for(int row=1;row<n+1;row++) {
        	for(int col=1;col<row+1;col++) {
        		System.out.print(row+" ");
        	}
        	System.out.println();
        }

	}

}

package com.day1;

import java.util.Scanner;

public class floyds_triangle {

	public static void main(String[] args) {
		Scanner myobj = new Scanner(System.in);
        int n = myobj.nextInt();
        int num=1;
        for(int row=1;row<n+1;row++) {
        	for(int col=row;col<row+num;col++) {
        		System.out.print(col+" ");
        	}        	
        	System.out.println();
        	num+=1;
        }

	}

}

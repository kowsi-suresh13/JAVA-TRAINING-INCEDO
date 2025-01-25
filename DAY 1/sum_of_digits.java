package com.day1;

import java.util.Scanner;

public class sum_of_digits {

	public static void main(String[] args) {
		Scanner myobj = new Scanner(System.in);
        int n = myobj.nextInt();
        int sum=0;
        int digit;
        while(n>0) {
        	digit = n%10;
        	sum+=digit;
        	n=n/10;
        }
        System.out.println(sum);
	}

}

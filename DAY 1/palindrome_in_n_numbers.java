package com.day1;

import java.util.Scanner;

public class palindrome_in_n_numbers {

	public static void main(String[] args) {
		Scanner myobj = new Scanner(System.in);
        int n = myobj.nextInt();       
        for(int num=10;num<n;num++) {
        	int temp=num;
        	int sum=0;
            while(temp>0) {
            	int rem = temp%10;
            	sum=(sum*10)+rem;
            	temp=temp/10;
            }
            if(num==sum) {
            	System.out.println(num);
            }
        }

	}

}

package com.day1;

import java.util.Scanner;
import java.math.*;

public class armstrong_num {

	public static void main(String[] args) {
		Scanner myobj = new Scanner(System.in);
        int n = myobj.nextInt();
        int temp = n;
        int new_temp = n;
        int sum=0;
        int count=0;
        while(n>0) {
        	int digit = n%10;
        	count+=1;
        	n=n/10;
        }
        while(temp>0) {
        	int digit = temp%10;
        	sum+=(Math.pow(digit, count));
        	temp=temp/10;	
        }
        
        if(new_temp==sum) {
            System.out.println(new_temp+" is an armstrong number");
        }
        else {
        	System.out.println(new_temp+" is not an armstrong number");
        }

	}

}

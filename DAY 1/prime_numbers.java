package com.day1;

import java.util.Scanner;

public class prime_numbers {

	public static void main(String[] args) {
		Scanner myobj = new Scanner(System.in);
        int n = myobj.nextInt();
        int flag=1;
        int sum=0;
        int count=0;
        for(int num=1;num<n+1;num++) {
        	for(int num2=2;num2<num;num2++) {
        		if(num%num2==0) {
        			flag=0;
        		}        		
        	}
        	if(flag==1) {
        		sum+=num;
        		count+=1;        		
        	}  
        	flag=1;
        }
        System.out.println("Sum of prime numbers is: "+sum);
        System.out.println("Average of prime numbers is: "+(sum/count));

	}

}

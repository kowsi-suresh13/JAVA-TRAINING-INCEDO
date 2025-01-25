package com.day1;

import java.math.*;

public class armstrong_nums_in_range {

	public static void main(String[] args) {
		//System.out.println("Armstrong numbers in range of 1-1000 are:");
        for(int n=1;n>1001;n++) {
        	int temp = n;
            int new_temp = n;
            int sum=0;
            int count=0;	       
	        while(n>0) {
	        	int digit = n%10;
	        	count+=1;
	        	n=n/10;
	        }
	        System.out.println(count);
	        while(temp>0) {
	        	int digit = temp%10;
	        	sum+=(Math.pow(digit, count));
	        	temp=temp/10;	
	        }
	        System.out.println(sum);
	        System.out.println(new_temp);
	        if(new_temp==sum) {
	            System.out.println(new_temp);
	        }       	        
        }

	}

}

package com.day1;

public class no_of_odd_num {

	public static void main(String[] args) {
		int count=0;
		for(int num=1;num<=100;num++) {
			if(num%2!=0) {
				count+=1;
			}
		}
		System.out.println(count);
	}

}

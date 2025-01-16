package com.day1;
import java.util.Scanner;

public class sum_of_n_num {

	public static void main(String[] args) {
		Scanner myobj = new Scanner(System.in);
        int n = myobj.nextInt();
        int sum=0;
        for(int num=1;num<=n;num++) {
        	sum+=num;
        }
        System.out.println(sum);
	}

}

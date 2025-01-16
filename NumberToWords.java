package com.day1;

import java.util.Scanner;

public class NumberToWords {

	  
	    private static final String[] ones = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
	                                            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	    
	    private static final String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	    
	    private static final String[] thousands = { "", "Thousand", "Million", "Billion" };

	    public static String convertToWords(long number) {
	        if (number == 0) {
	            return "Zero";
	        }
	        
	        String result = "";
	        int i = 0;
	        
	        while (number > 0) {
	            if (number % 1000 != 0) {
	                result = convertThreeDigitGroup((int) (number % 1000)) + thousands[i] + " " + result;
	            }
	            number /= 1000;
	            i++;
	        }
	        
	        return result.trim();
	    }
	    
	    private static String convertThreeDigitGroup(int num) {
	        String result = "";
	        
	        if (num >= 100) {
	            result += ones[num / 100] + " Hundred ";
	            num %= 100;
	        }
	        
	        if (num >= 20) {
	            result += tens[num / 10] + " ";
	            num %= 10;
	        }
	        
	        if (num > 0) {
	            result += ones[num] + " ";
	        }
	        
	        return result;
	    }

	    public static void main(String[] args) {
	        Scanner myobj = new Scanner(System.in);
	        long number = myobj.nextLong();
	        System.out.println("Number: " + number);
	        System.out.println("In Words: " + convertToWords(number));
	    }

}

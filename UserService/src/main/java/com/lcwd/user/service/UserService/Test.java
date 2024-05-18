package com.lcwd.user.service.UserService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Test {
	
	
	public static void main(String [] args) {
		
//		Scanner sc = new Scanner(System.in);
//		
//		String st = sc.next();
//		
//		HashMap<Character, Integer> hm = new HashMap<>();
//		
//		char ch='a';
//		int temp=0;
//		
//		for( int i =0 ; i< st.length() ; i++) {
//			
//			ch = st.charAt(i);
//						
//			if(hm.containsKey(ch)) {
//				temp = hm.get(ch);
//				temp++;
//				hm.put(ch, temp);
//			}else {
//				hm.put(ch, 1);
//			}
//		}
//		
//		temp = Integer.MIN_VALUE;
//		
//		for( Map.Entry<Character, Integer> entry  : hm.entrySet()) {
//			
//			if(temp < entry.getValue()) {
//				temp= entry.getValue();
//				ch=entry.getKey();
//			}
//		}
//		
//		System.out.print(ch +":" +temp);
		

		        Scanner scanner = new Scanner(System.in);

		        System.out.print("Enter a number: ");
		        int number = scanner.nextInt();

		        if (isPalindrome(number)) {
		            System.out.println(number + " is a palindrome number.");
		        } else {
		            System.out.println(number + " is not a palindrome number.");
		        }

		        scanner.close();
		    }

		    // Function to check if a number is a palindrome
		    private static boolean isPalindrome(int num) {
		        int originalNumber = num;
		        int reversedNumber = 0;

		        while (num > 0) {
		            int digit = num % 10;
		            reversedNumber = reversedNumber * 10 + digit;
		            num /= 10;
		        }

		        return originalNumber == reversedNumber;
		   
	}

}

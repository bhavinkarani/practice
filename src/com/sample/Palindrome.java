package com.sample;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        String input;
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a string to check if it is a palindrome");
        input = in.nextLine();
        System.out.println("is String palindrome: "+isPalindrome(input));
        System.out.println("is String palindrome no extra space: "+isPalindromeNoExtraSpace(input));
    }

    private static boolean isPalindromeNoExtraSpace(String input) {
        int len = input.length();
        for(int i=0, j=len-1; i<j;i++, j--){
            if(input.charAt(i)!=input.charAt(j)){
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindrome(String input) {
        String reverse = reverse(input);
        return reverse.equals(input);
    }

    private static String reverse(String input) {
        StringBuilder sb = new StringBuilder();
        for(char c: input.toCharArray()){
            sb.insert(0,c);
        }
        return sb.toString();
    }
}

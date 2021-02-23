package com.sample;

import java.util.Scanner;

public class Factorial {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an number to find factorial : ");
        int input = in.nextInt();
        System.out.println(factorial(input));
        System.out.println(factorialRecur(input));
    }

    private static int factorialRecur(int input) {
        if(input==1){
            return 1;
        }
        return input * factorialRecur(input-1);
    }

    private static int factorial(int input) {
        int fact=1;
        for(int i = input ; i>1; i--){
            fact = fact * i;
        }
        return fact;
    }

}

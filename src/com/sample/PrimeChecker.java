package com.sample;

import java.util.Scanner;

public class PrimeChecker {
    public static void main (String []args) {
        //sample input : 1073807359
        System.out.println("Enter a number: ");
        int num = new Scanner(System.in).nextInt();
        System.out.println("Is number "+num+" a prime ? "+isPrime(num));
        System.out.println("Is number "+num+" a prime ? "+isNumPrime(num));
        System.out.println("Is number "+num+" a prime ? "+isNumPrimeSqr(num));
        System.out.println("Is number "+num+" a prime ? "+isNumPrimeSqrOdd(num));
    }

    private static boolean isNumPrimeSqrOdd(int num) {
        if(num<2) return false;
        if(num==2) return true;
        for(int i=3; i*i<=num; i=i+2){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    private static boolean isNumPrimeSqr(int num) {
        if(num<2) return false;
        if(num==2) return true;
        for(int i=3; i*i<=num; i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    private static boolean isNumPrime(int num) {
        if(num<2) return false;
        if(num==2) return true;
        for(int i =3; i<=num/2;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    private static boolean isPrime(int num) {
        if(num<2) return false;
        if(num==2) return true;
        for(int i =3; i<num;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}

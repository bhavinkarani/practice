package com.sample;

import java.util.Scanner;

public class PrintNumberWithoutLoop {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter any number: ");
        int i = in.nextInt();
        printUpto(i, 1);
    }

    private static void printUpto(int range, int currentNum) {
        if(range>=currentNum){
            System.out.println(currentNum);
            printUpto(range, currentNum+1);
        }
    }

}

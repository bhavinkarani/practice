package com.leet.temp.Leet;

import java.util.Arrays;

public class FindSumEqualToGivenNumber {

    public static void main(String args[]){
        int A[] = { 1, 4, 45, 6, 10, -8 };
        int n = 2;
        if(doWehaveSum(A,n)){
            System.out.println("positive");
        }else{
            System.out.println("negative");
        }
    }

    private static boolean doWehaveSum(int[] a, int sum) {
        Arrays.sort(a);
        int i=0;
        int len = a.length;
        for(int num : a){
            System.out.println("looking for pair with "+num);
            if(checkIfWeHaveSumWith(a, i, sum-num, 0, len-1)){
              return true;
            }
            i++;
        }
        return false;
    }

    private static boolean checkIfWeHaveSumWith(int[] a, int originalIndex, int expectedNumber, int first, int last) {
        int i= last-first/2;
        while(true){
            if(first >= last){
                return false;
            }
            if(a[i] == expectedNumber && i!=originalIndex){
                System.out.println("expected number: "+expectedNumber +" found at: "+i);
                return true;
            }else if(a[i]>expectedNumber){
                return checkIfWeHaveSumWith(a, originalIndex, expectedNumber, first, i-1);
            }else if(a[i]<expectedNumber){
                return checkIfWeHaveSumWith(a, originalIndex, expectedNumber, i+1, last);
            }
        }
    }
}

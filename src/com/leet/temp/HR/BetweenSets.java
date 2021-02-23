package com.leet.temp.HR;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BetweenSets {
    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        // get the heighest element from the first array
        for(int i: a){
            if(max<i)
                max = i;
        }
        // get the smallest element from the first array
        for(int i: b){
            if(min>i)
                min = i;
        }

        //check if max is divisible by all the numbers in first list
        for(int i : a){
            if(max%i!=0){
                max = findLCM(a, max);
            }
        }

        //check if max can divide all the numbers in second list
        for(int i : b){
            if(i%max!=0){
                return 0;
            }
        }
        int res = 1;
        max = max+max;
        while(max<=min){
            boolean divisible = true;
            for(int i: b){
                if(i%max!=0){
                    divisible = false;
                }
            }
            if(divisible == true){
                res = res+1;
            }
            max = max+1;
        }
        return res;
    }

    private static int findLCM(List<Integer> a, int max) {
        while(max<=100){
            boolean divisible = true;
            for(int i : a ){
                if(max%i!=0){
                    divisible = false;
                }
            }
            if(divisible == true){
                return max;
            }
            max++;
        }
        return max;
    }

    public static void main (String[] args){
        List<Integer> a = Arrays.asList(2,3,6);

        List<Integer> b = Arrays.asList(42,84);
        System.out.println(getTotalX(a,b));

    }
}

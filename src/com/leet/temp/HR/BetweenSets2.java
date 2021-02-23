package com.leet.temp.HR;

import java.util.Arrays;
import java.util.List;

public class BetweenSets2 {
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
        int res =0;
        for(int i = max; i <= min ; i++){
            if(isDividedBy(a,i) && isDivisibleBy(b,i)){
                res = res+1;
            }
        }
        return res;
    }

    private static boolean isDivisibleBy(List<Integer> b, int i) {
        for(int num:b){
            if(num%i!=0){
                return false;
            }
        }
        return true;
    }

    private static boolean isDividedBy(List<Integer> a, int i) {
        for(int num: a){
            if(i%num!=0){
                return false;
            }
        }
        return true;
    }

    public static void main (String[] args){
        List<Integer> a = Arrays.asList(1);

        List<Integer> b = Arrays.asList(100);
        System.out.println(getTotalX(a,b));

    }
}

package com.leet;

public class repeatingNumberChecker {
    private static final int VALID_COUNT = 2;
    public static void main(String[] args) {
        // write your code here
        System.out.println(double23(new int[]{2, 2}));   // true
        System.out.println(double23(new int[]{3, 3}));   // true
        System.out.println(double23(new int[]{2, 3}));   // false
    }

    private static boolean double23(int[] nums) {
        int count2 =0;
        int count3 = 0;
        for(int i : nums){
            if(i==2){
                count2 ++;
            }else if (i ==3){
                count3 ++;
            }
        }
        return (validCount(count2) || validCount(count3));
    }

    private static boolean validCount(int count) {
        return (count==VALID_COUNT);
    }
}

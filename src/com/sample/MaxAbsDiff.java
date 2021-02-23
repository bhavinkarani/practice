package com.sample;

public class MaxAbsDiff {
    public static void main(String[] args)
    {
        int[] arr = { 12, 5, -10, 10, 7, 8 }; //output should be 22
        System.out.print(maxAbsDiff(arr));
    }

    private static int maxAbsDiff(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for(int num: arr){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return max - min;
    }
}

package com.leet;

public class CenteredAverage {
    public static void main(String[] args) {
        System.out.println(centeredAverage(new int[]{1, 2, 3, 4, 100}));            // → 3
        System.out.println(centeredAverage(new int[]{1, 1, 5, 5, 10, 8, 7}));       // → 5
        System.out.println(centeredAverage(new int[]{-10, -4, -2, -4, -2, 0}));     // → -3
    }

    private static int centeredAverage(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int total = 0;
        for (int i : nums) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
            total = total + i;
        }
        total = total - min - max;
        return (total / (nums.length - 2));
    }
}

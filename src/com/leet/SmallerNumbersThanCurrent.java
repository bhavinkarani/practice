package com.leet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SmallerNumbersThanCurrent {

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int i =0; i<nums.length;i++){
            if(count.get(nums[i])==null){
                count.put(nums[i], 1);
            }
            else{
                count.put(nums[i], count.get(nums[i])+1);
            }
        }
        int[] res = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int lowerNumer =0;
            for(int j : count.keySet()){
                if (j<nums[i]){
                    lowerNumer = lowerNumer+ count.get(j);
                }
            }
            res[i] = lowerNumer;
        }
        return res;
    }
    public static void main(String args[]){
        int[] smallerNumbersThanCurrent = new int[] //{8,1,2,2,3};
        //{6,5,4,8};
                {7,7,7,7};
        for(int i: smallerNumbersThanCurrent(smallerNumbersThanCurrent)){
            System.out.print(i+", ");
        }
        for(int i: smallerNumbersThanCurrent2(smallerNumbersThanCurrent)){
            System.out.print(i+", ");
        }
        for(int i: smallerNumbersThanCurrent3(smallerNumbersThanCurrent)){
            System.out.print(i+", ");
        }
    }

    private static int[] smallerNumbersThanCurrent3(int[] nums) {
        //int[] sorted = Arrays.stream(nums).sorted().toArray();
        int[] res = new int[nums.length];
        for(int i =0; i< nums.length; i++){
            int count =0;
            for(int j: nums){
                if(j < nums[i]){
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }

    private static int[] smallerNumbersThanCurrent2(int[] nums) {
        int[] sorted = Arrays.stream(nums).sorted().toArray();
        int[] res = new int[nums.length];
        for(int i =0; i< nums.length; i++){
            int count =0;
            for(int j: sorted){
                if(j < nums[i]){
                    count++;
                }else{
                    break;
                }
            }
            res[i] = count;
        }
        return res;
    }
}

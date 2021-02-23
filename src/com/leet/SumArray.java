package com.leet;

import java.util.HashMap;
import java.util.Map;

public class SumArray {
    public int[] twoSum(int[] nums, int target) {
        Map< Integer, Integer> maps = new HashMap<>();
        for(int i=0; i< nums.length-1; i++){
            int required = target - nums[i];
            if(maps.containsKey(required)){
                return new int[]{i, maps.get(required)};
            }
            else{
                maps.put(nums[i], i);
            }
        }
        return new int[]{-1,-1};
    }
    public static void main (String arags[]){
        SumArray sa = new SumArray();
        sa.twoSum(new int[]{3,2,4},6);
    }
}

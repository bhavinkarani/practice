package com.leet;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class GoodPairs {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> combination = new HashMap<>();
        int res=0;
        for(int num : nums){
            if(combination.containsKey(num)){
                combination.put(num, combination.get(num)+1);
            }else{
                combination.put(num,1);
            }
        }
        for(int val : combination.values()){
            res = res+getCombinations(val);
        }
        return res;
    }

    private int getCombinations(int val) {
        if(val < 2){
            return 0;
        }
        if(val ==2){
            return 1;
        }
        int res =  (fact(val).divide(BigInteger.valueOf(2)).divide(fact(val-2))).intValue();
        System.out.println(res);
        return res;
    }

    private BigInteger fact(int val) {
        BigInteger res =BigInteger.ONE;
        for(int i= val; i>0;i--){
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }

    public static void main (String args[]){
        GoodPairs gp = new GoodPairs();
        //int[] nums = new int [] {1,2,3,1,1,3};
        int[] nums = new int [] //{1,1,1,1};
                {2,2,1,5,1,5,5,2,3,1,1,5,3,2,3,3,3,1,3,3,4,3,1,3,1,4,5,5,2,2,1,3,5,2,2,4,3,2,5,3,1,1,3,3,2,5,2,1,2,4,3,4,4,3,2,4,4,1,3,3,3,5,5,5,4,1,1,2,3,3,2,5,3,4,5,3,1,2,5,4,5,2,3,3,1,5,2,4,2,4,4,3,1,3};
      //  {6,5,1,5,7,7,9,1,5,7,1,6,10,9,7,4,1,8,7,1,1,8,6,4,7,4,10,5,3,9,10,1,9,5,5,4,1,7,4,2,9,2,6,6,4,2,10,3,5,3,6,4,7,4,6,4,4,6,3,4,10,1,10,6,10,4,9,6,6,4,8,6,9,5,4};
        System.out.println(gp.numIdenticalPairs(nums));
        System.out.println(gp.numIdenticalPairs2(nums));
    }

    private int numIdenticalPairs2(int[] nums) {
        int res=0;
        for(int i=0; i<nums.length;i++){
            for(int j=i+1; j< nums.length;j++){
                if(nums[i]==nums[j]){
                    res++;
                }
            }
        }
        return res;
    }
}

package com.leet.temp.Leet;

/*
Given an array of integers arr and two integers k and threshold.

Return the number of sub-arrays of size k and average greater than or equal to threshold.
Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
Output: 3
Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively. All other sub-arrays of size 3 have averages less than 4 (the threshold).

 */
public class NumberOfSubarrays {


    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int count =0;
        for(int i=0 ; i <= arr.length-k ; i++){
            int average =0;
            for(int j =i; j < i+k; j++) {
                average = average + arr[j];
            }
            average = average /k;
            if(average >= threshold){
                count ++;
            }
        }
        return count;
    }

    public static int numOfSubarrays2(int[] arr, int k, int threshold) {
        //arr = [2,2,2,2,5,5,5,8]
        int count =0;
        int average =0;
        for(int i=0;i<k ;i++){
            average = average + arr[i];
        }
        if(average/k >=threshold){
            count++;
        }
        for(int i=1 ; i <= arr.length-k ; i++){
            average = average - arr[i-1]+arr[i+k-1];
            if(average/k >=threshold){
                count++;
            }

        }
        return count;
    }


    public static void main(String args[]){
        int[] arr = new int[] {2,2,2,2,5,5,5,8};
        System.out.print(numOfSubarrays2(arr, 3, 4));
    }
}

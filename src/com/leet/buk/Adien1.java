package com.leet.buk;

import java.util.HashMap;
import java.util.Map;

class Adyen1 {

    public static void main (String args[]){
        /*int A[] ={1,1,3,3,3,4,5,5,5,5};
        int y = 6;*/

        /*int A[] ={1,1,3,3,3,4,5,5,5,5};
        int y = 2;*/

        /*int A[] ={1,1,3,3,3,4,5,5,5,5};
        int y = 3;*/

        /*int A[] ={1,1,3,3,3,4,5,5,5};
        int y = 4;*/

        /*int A[] ={1,1,3,3,3,4,5,5,5};
        int y = 5;*/
/*
        int A[] ={3,4,5,5,5};
        int y = 5;*/
/*
        int A[] = {1,1,3,3,4,4,4,5,5,6,6,6,6,6,6};
        int y=2;*/

        int A[] = {1,1,3,3,4,4,4,5,5};
        int y=8;
        int ans = solution(A, y);
        int ans2 = solution2(A, y);
        System.out.println(ans + "===" +ans2);

    }

    private static int solution2(int[] a, int y) {

        int n = a.length;
        int best = 0;
        int count = 1;

        for (int i = 0; i < n-y-1; i++) {
            if (a[i] == a[i + 1])
                count = count + 1;
            else
                count = 1;
            if (count > best)
                best = count;
        }
        int result = Math.max(best+y, Math.min(y+1, n));

        return result;
    }

  /*  private static int solution(int[] a, int y) {
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        //max variable should store the maximum number of nails of same length except the hammered nails
        int max =0;
        //this loop finds out maximum length of any integer
        for(int i=0;i < a.length-y; i++){
            if(countMap.get(a[i])!=null){
                countMap.put(a[i],countMap.get(a[i])+1);
            }else{
                countMap.put(a[i],1);
            }
            if(countMap.get(a[i])>max){
                max = countMap.get(a[i]);
            }
        }
        return max+y;
       // return Math.min(max+y, Math.min(y+1, a.length));
    }*/

    public static int solution(int[] A, int Y) {
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        int max =0;
        for(int i=0;i < A.length-Y; i++){
            if(countMap.get(A[i])!=null){
                countMap.put(A[i],countMap.get(A[i])+1);
            }else{
                countMap.put(A[i],1);
            }
            if(countMap.get(A[i])>max){
                max = countMap.get(A[i]);
            }
        }
        return max+Y;
    }
}

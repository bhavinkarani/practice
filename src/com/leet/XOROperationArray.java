package com.leet;

public class XOROperationArray {

    public static void main(String args[]){
        System.out.println(xorOperation(10,5));
    }

    public static int xorOperation(int n, int start) {
        int res =start;
        for(int i=1; i<n; i++){
            int j = start + (2*i);
            res = res ^ j;
        }
        return res;
    }
}

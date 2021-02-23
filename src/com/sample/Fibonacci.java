package com.sample;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fibonacci {

    //0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181

    public static void main(String args[]){

        System.out.println("Enter length of number Fibonacci series: ");
        int num = new Scanner(System.in).nextInt();

        System.out.println(fibRec(num));
        Map<Integer,Integer> fibMap = new HashMap<>();
        fibMap.put(0,0);
        fibMap.put(1,1);
        System.out.println(fibonacciMem(num, fibMap));
        System.out.println(fibArr(num));
        System.out.println(fib(num));
    }

    private static int fib(int num) {
        int a= 0;int b=1; int fib =0;
        if(num<2) return num;
        for(int i=2;i<=num;i++){
            fib= a+b;
            a=b;
            b=fib;
        }
        return fib;
    }

    private static int fibArr(int num) {
        int fib[] = new int[num+1];
        fib[0] =0; fib[1]=1;
        for(int i=2;i<=num;i++){
            fib[i]= fib[i-1]+fib[i-2];
        }
        return fib[num];
    }

    private static int fibonacciMem(int num, Map<Integer, Integer> fibMap) {
        if(fibMap.get(num)!=null){
            return fibMap.get(num);
        }
        fibMap.put(num,fibonacciMem(num-1, fibMap)+fibonacciMem(num-2, fibMap));
        return fibMap.get(num);
    }

    private static int fibRec(int num) {
        if(num<2){
            return num;
        }
        return fibRec(num-1)+fibRec(num-2);
    }
}

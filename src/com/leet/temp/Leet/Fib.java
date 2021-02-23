package com.leet.temp.Leet;

public class Fib {

    public static void main(String args[]){
        int n=30;
        long startTime, stopTime, elapsedTime;
        startTime = System.currentTimeMillis();
        System.out.println(fib(n));
        System.out.println("------"+(System.currentTimeMillis() - startTime));
        startTime = System.currentTimeMillis();
        System.out.println(fib2(n));
        System.out.println("------"+(System.currentTimeMillis() - startTime));
        startTime = System.currentTimeMillis();
        System.out.println(fib3(n));
        System.out.println("------"+(System.currentTimeMillis() - startTime));
        // \u000d System.out.println("comment executed");
    }

    private static int fib(int i) {
        if(i<= 1){
            return i;
        }
        return fib(i-1)+ fib(i-2);
    }

    private static int fib2(int i) {
        int fib_arr[] = new int[i+1];
        fib_arr[0] = 0;
        fib_arr[1] = 1;
        for(int x=2;x<=i;x++){
            fib_arr[x]= fib_arr[x-1]+fib_arr[x-2];
        }
        return fib_arr[i];
    }

    private static int fib3(int n){
        if(n<=1){
            return n;
        }
        int a=0;
        int b=1;
        int fib=0;
        for(int i=2;i<=n;i++){
            fib = a + b;
            a = b;
            b = fib;
        }
        return fib;
    }

}

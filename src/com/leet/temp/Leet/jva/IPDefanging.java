package com.leet.temp.Leet.jva;

public class IPDefanging {
    public static void main(String args[]){
        String a="1.2.3.1";
        for(Character j : a.toCharArray()){
            System.out.print(j);
        }
        a = a.replace(".","[.]");
        System.out.println("-----"+a);
    }
}

package com.leet.temp.Leet;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Maximum69 {
    public static void main(String args[]){
        String s = "   t   ";
        System.out.println(s);
        /*int res = getMax(99696969);
        System.out.println(res);*/
    }

    private static int getMax(int num) {
        String str = String.valueOf(num);

        str = str.replaceFirst("6","9");
        return Integer.valueOf(str);
    }
    public List<String> printVertically(String str) {
        return Arrays.stream(str.split(" ")).map(s -> s.trim()).collect(Collectors.toList());
    }
}

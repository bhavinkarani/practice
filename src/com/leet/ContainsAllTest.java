package com.leet;

import java.util.ArrayList;
import java.util.List;

public class ContainsAllTest {
    public static void main (String args[] ){
        List<String> allStrings = new ArrayList<>();
        allStrings.add("aaa");
        allStrings.add("bbb");
        allStrings.add("ccc");
        allStrings.add("ddd");
        allStrings.add("eee");

        List<String> nullList = null;

        List<String> noteSealBags = new ArrayList<>();
        //nonNull.add("aaa");

        List<String> nonNullwithElement = new ArrayList<>();
        nonNullwithElement.add("a");

        List<String> coinSealbags = new ArrayList<>();
        coinSealbags.add("aaa");
        coinSealbags.add("bbb");

       // System.out.println(allStrings.containsAll(nullList));
        System.out.println(allStrings.containsAll(noteSealBags));
        System.out.println(allStrings.containsAll(nonNullwithElement));
        System.out.println(allStrings.containsAll(coinSealbags));


    }
}

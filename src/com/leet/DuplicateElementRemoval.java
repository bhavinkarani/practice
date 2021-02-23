package com.leet;

import java.util.*;

import static java.util.Arrays.*;

public class DuplicateElementRemoval {

    public static void main(String args[]){

        int[] input = new int[]{1,1,4,5,6,7,4,3,7,6, 5, 7, 8,9};

        printUniqueNumbers(input);
        printUniqueNumbers2(input);
        printUniqueNumbers3(input);
    }

    private static void printUniqueNumbers3(int[] input) {
        LinkedHashSet<Integer> holder = new LinkedHashSet();
        for(int a : input){
            holder.add(a);
        }
        System.out.print(holder);
    }

    private static void printUniqueNumbers2(int[] input) {
        Set<Integer> holder = new HashSet<>();
        for(int i = 0; i < input.length; i++) {
            if (holder.contains(input[i])){
                input[i]=-1;
            }else{
                holder.add(input[i]);
            }
        }
        System.out.print(Arrays.toString(input));
    }

    private static void printUniqueNumbers(int[] input) {
        List<Integer> output = new LinkedList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for(int i : input ){
            if(count.get(i)!=null){
                count.put(i, count.get(i)+1);
            }else{
                count.put(i, 1);
                output.add(i);
            }
        }
        System.out.print(output);

    }
}

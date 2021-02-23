package com.leet;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Bingo {

        private static final int MAX = 75;
        public static void main(String args[]) throws IOException {


        List<Integer> integers =
                IntStream.rangeClosed(1, MAX)                      // <-- creates a stream of ints
                        .boxed()                                // <-- converts them to Integers
                        .collect(Collectors.toList());
        Collections.shuffle(integers);
       // System.out.println(integers);
        System.out.print("start playing Bingo !!! Are you ready ?? ");

        Scanner scanner = new Scanner(System.in);
        int i=0;
        while(true){
            System.in.read();
            if(i<MAX) {
                System.out.println(" "+integers.get(i));
                i++;
            }else{
                System.out.println("Game Over");
            }
        }



    }
}

package com.leet;

import java.io.IOException;
import java.util.Random;

public class RandomCharacterGenerator {
    public static void main(String[] args) throws IOException {
        Random r = new Random();
        for(int i=0; i<50; i++) {
            char c = (char) (r.nextInt(26) + 'a');
            System.out.println(" "+c);
            System.in.read();
        }
    }
}

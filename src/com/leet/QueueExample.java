package com.leet;

import java.util.concurrent.ArrayBlockingQueue;

public class QueueExample {

    public static void main(String[] args)
    {
        int capacity = 5;

        // Create object to store 5 names
        ArrayBlockingQueue<String> names = new
                ArrayBlockingQueue<String>(capacity);

        // Add element to ArrayBlockingQueue
        names.add("Aman");
        names.add("Siddhant");


        // Print size of queue after adding numbers
        int size = names.size();
        System.out.println("After addding numbers"+
                " Queue size = "+size);


        // Add more elements to ArrayBlockingQueue
        names.add("Raunak");
        names.add("Suvo");

        // Print size of queue after adding numbers
        size=names.size();
        System.out.println("After addding more numbers"+
                " Queue size = "+size);

    }
}
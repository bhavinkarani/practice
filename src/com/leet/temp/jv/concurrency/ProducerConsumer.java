package nl.ing.api.cash.order.temp.jv.concurrency;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        Processor2 p = new Processor2();
        Thread t1 = new Thread(()-> {
            try {
                p.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()-> {
            try {
                p.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }


    static class Processor2{

        LinkedList<Integer> list = new LinkedList<Integer>();
        final Object lock = new Object();
        private final int LIMIT =10;
        public void produce() throws InterruptedException {
            int value =0;
            while(true){
                synchronized (lock){
                    while(list.size()==LIMIT){
                        lock.wait();
                    }
                    list.add(value++);
                    lock.notify();
                    Thread.sleep(1000);
                }
            }
        }
        public void consume() throws InterruptedException {
            Random rnd = new Random();
            while(true){
                synchronized (lock) {
                    while(list.size()==0){
                        lock.wait();
                    }
                    System.out.println("list of size is : " + list.size());
                    int value = list.removeFirst();
                    System.out.println("value is : " + value);
                    lock.notify();
                }
                Thread.sleep(rnd.nextInt(1000));
            }


        }

    }
}

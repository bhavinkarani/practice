package nl.ing.api.cash.order.temp.jv.concurrency;

import java.util.Scanner;

public class WaitNotify {

    public static void main(String[] args) throws InterruptedException {
        Processor1 p = new Processor1();
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


    static class Processor1{

        public void produce() throws InterruptedException {
            System.out.println("Producing ");
            synchronized (this) {
                wait();
                System.out.println("returned to producer");
            }

        }
        public void consume() throws InterruptedException {
            Scanner scanner = new Scanner(System.in);
            Thread.sleep(2000);
            synchronized (this){
                System.out.println("waiting for consumer to action");
                scanner.nextLine();
                System.out.println("Consumer responded");
                notify();
                //sleep does not release lock so even after producer thread is runnable again it does not run until sleep is finished.
                Thread.sleep(5000);
            }


        }

    }

}


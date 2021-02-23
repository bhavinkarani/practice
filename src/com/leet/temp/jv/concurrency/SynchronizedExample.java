package nl.ing.api.cash.order.temp.jv.concurrency;

public class SynchronizedExample {

    int count = 0;
    public static void main(String[] args) throws InterruptedException {
        SynchronizedExample se = new SynchronizedExample();
        Thread t1 = new Thread(()-> {
            for(int i=0;i<10000;i++){
                se.count++;
            }
        });
        Thread t2 = new Thread(()-> {
            for(int i=0;i<10000;i++){
                se.count++;
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(se.count);

        String lock = new String();
        SynchronizedExample se2 = new SynchronizedExample();
        Thread t3 = new Thread(()-> {
            for(int i=0;i<10000;i++){
                synchronized (lock){
                    se2.count++;
                }

            }
        });
        Thread t4 = new Thread(()-> {
            for(int i=0;i<10000;i++){
                synchronized (lock) {
                    se2.count++;
                }
            }
        });
        t3.start();
        t4.start();

        t3.join();
        t4.join();

        System.out.println(se2.count);

    }
}

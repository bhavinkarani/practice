package nl.ing.api.cash.order.temp.jv.concurrency;

public class ReaderWriterSwingWithVolatileExample {
    static int  c;

    public static void main(String[] args){
        Thread t1 = new Thread(() -> {
            int temp =0;
            while(true){
                if(temp!=c){
                    temp = c;
                    System.out.println("reader thread reading c ="+ c);
                }
            }
        });

        Thread t2 = new Thread(()-> {
           while(c<5){
               c++;
               System.out.println("writer thread writting c = "+c);
               try{
                   Thread.sleep(1000);
               }catch(Exception e){
                   System.out.print("Got exception");
               }
           }
        });
        long id = Thread.currentThread().getId();
        String name = Thread.currentThread().getName();
        /*int priority = Thread.currentThread().getPriority();
        Thread.State state = Thread.currentThread().getState();
        String threadGroupName = Thread.currentThread().getThreadGroup().getName();
        System.out.println("id="+id+"; name="+name+"; priority="+priority+"; state="+state+"; threadGroupName="+threadGroupName);
        System.out.println(t1.getState());*/
        /*t1.start();
        t2.start();*/


        /*int a  = 1/0;
        System.out.print(a);*/
        Double d = 1.0/0;
        System.out.print(d);
        System.out.println(Math.sqrt(24));

    }
}

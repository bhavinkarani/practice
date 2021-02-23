package nl.ing.api.cash.order.temp.jv.stream;

import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Stream1 {
    public static void main(String argsp[]){
        Stream<Integer> a = Stream.of(1,2,3,4,5,6,7,8,9,10);
        a.forEach(System.out::println);


        IntStream b = IntStream.range(90,100);
        b.forEach(System.out::println);

        IntStream c = IntStream.range(10,15);
        System.out.println(c.sum());

        Supplier<Stream<String>> strs = ()->Stream.of("A", "B", "C", "D");
        System.out.println(strs.get().findFirst().get());

        System.out.println(strs.get().findAny().get());

    }
}

package nl.ing.api.cash.order.temp.strange;


public class Strange {
    public static void main(String[] arr‮) {
        Integer a = 42;
        Integer b = 42;
        System.out.println(a == b);
        Integer c = 666;
        Integer d = 666;
        System.out.println(c == d);

        char ch = '0';
        ch *= 1.1;
        System.out.println(ch);

//        String _‎ = "Hello ";
//         _‏ = "World";
//         _‎‏ = " !!";
//        System.out.println(_‎+_‏+_‎‏);

        float x=0.0f;
        if (x != (x += 0.0f))
            System.out.println("WTF");
    }

}

package nl.ing.api.cash.order.temp.jv.collection;

import java.util.HashMap;

public class HashMapClone {
    public static void main(String[] args){
        HashMap<Integer, String> abc = new HashMap<>();
        abc.put(1,"bhavin");
        abc.put(2,"Pratik");
        abc.put(3,"medhansh");
        abc.put(4,"Rahul");
        System.out.println(abc);
        HashMap<Integer,String> pqr  = (HashMap<Integer,String> )abc.clone();
        System.out.println(pqr);

        abc.put(1,"bhavin karani");
        System.out.println(abc);
        System.out.println(pqr);

    }
}

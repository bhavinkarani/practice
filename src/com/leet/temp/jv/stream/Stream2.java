package nl.ing.api.cash.order.temp.jv.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream2 {

    public static void main(String args[]){
        int arr[] = new int[]{1,2,3,4,5,6,7,8,9,10};
        List<Integer> list1 = new ArrayList(Arrays.asList(arr));
        int arr2[] = new int[]{2,4,6,8,10};
        List<Integer> list2 = new ArrayList(Arrays.asList(arr2));
        System.out.println(getDuplicate(list1, list2));
    }

    private static List<Integer> getDuplicate(List<Integer> list1, List<Integer> list2) {
        System.out.print("");
        Map<Integer, Long> map = list1.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        list2.stream().forEach(e -> {
            if(map.containsKey(e)){
                map.put(e, map.get(e)+1);
            }
        });
        return map.entrySet().stream().filter(e-> e.getValue() >= 2).map(e-> e.getKey()).collect(Collectors.toList());
    }
}

package nl.ing.api.cash.order.temp.jv.adn;

import java.util.HashMap;
import java.util.Map;

public class Adyen1 {

    public static void main (String args[]){
        /*int A[] ={1,1,3,3,3,4,5,5,5,5};
        int y = 6;*/

        /*int A[] ={1,1,3,3,3,4,5,5,5,5};
        int y = 2;*/

        /*int A[] ={1,1,3,3,3,4,5,5,5,5};
        int y = 3;*/

        /*int A[] ={1,1,3,3,3,4,5,5,5};
        int y = 4;*/

        int A[] ={1,1,3,3,3,4,5,5,5};
        int y = 5;
        int ans = solution(A, y);
        System.out.println(ans);

    }

    private static int solution(int[] a, int y) {
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        //max variable should store the maximum number of nails of same length except the hammered nails
        int max =0;
        //this loop finds out maximum length of any integer
        for(int i=0;i < a.length-y; i++){
            if(countMap.get(a[i])!=null){
                countMap.put(a[i],countMap.get(a[i])+1);
                if(countMap.get(a[i])>max){
                    max = countMap.get(a[i]);
                }
            }else{
                countMap.put(a[i],1);
            }
        }
        return max + y;
    }
}

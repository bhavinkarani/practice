package com.leet.buk.Adyen;

import java.util.ArrayList;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 s2 = new Solution2();
        printArr( s2.solution(2,4 ));
        printArr( s2.solution(3,20 ));
        printArr( s2.solution(5,6 ));


        printArr( s2.solution(5,0 ));
        printArr( s2.solution(-1,0 ));
        printArr( s2.solution(-1,5 ));
        printArr( s2.solution(3,-1 ));

        printArr( s2.solution(3,5 ));

        printArr( s2.solution(5,5 ));
        printArr( s2.solution(8,4 ));
        printArr( s2.solution(3,3 )); //aba ,abc ,aca
        printArr( s2.solution(3,1 )); //should be -> aba ,abc but is ab ,ac

        //System.out.println( s2.solution(2,4 ));
    }

    private static void printArr(String[] solution) {
        for(String sol : solution){
            System.out.print(" ,"+sol);
        }
        System.out.println();
    }

    public String[] solution(int N, int K) {
        if (N < 1 || K < 1 ) {
        //if (N == 0 ) {

            return new String[] {""};
        }
        ArrayList<String> result = new ArrayList<String>();
        String[] res = solution(N - 1, K);
        for (String p : res) {
            for (char l : new char[] {'a', 'b', 'c'}) {
                int pLen = p.length();
                if (pLen == 0 || p.charAt(pLen - 1) != l) {
                    result.add(p + l);
                }
            }
        }
        int prefSize = Math.min(result.size(), K);
        return result.subList(0, prefSize).toArray(new String[prefSize]);
    }
}

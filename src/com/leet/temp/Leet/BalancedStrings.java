package com.leet.temp.Leet;

public class BalancedStrings {
    public int balancedStringSplit(String s) {
        int countL =0; int countR=0;
        int balancedStrings =0;
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)=='L'){
                countL++;
            }else if(s.charAt(i)=='R'){
                countR++;
            }
            if(countL>0 && countL==countR){
                balancedStrings++;
            }
        }
        return balancedStrings;
    }
}

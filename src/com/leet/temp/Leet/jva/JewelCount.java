package com.leet.temp.Leet.jva;

import java.util.HashMap;
import java.util.Map;

public class JewelCount {

    public int numJewelsInStones(String J, String S) {
        Map<Character, Character> jewels = new HashMap<Character,Character>();
        int jewelCount=0;
        for(Character j : J.toCharArray() ){
            jewels.put(j,j);
        }
        for(Character s : S.toCharArray()){
            if(jewels.get(s)!=null){
                jewelCount++;
            }
        }
        return jewelCount;
    }
}

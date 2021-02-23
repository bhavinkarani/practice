package com.leet.temp.HR;


import java.net.Inet4Address;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeadersBoard2 {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] res = new int[alice.length];
        Map<Integer, Integer> ranking = getRankingFromScores(scores);
        for(int i=0; i< alice.length;i++){
            res[i] = findAlicePosition(alice[i], ranking);
        }
        return res;

    }

    private static int findAlicePosition(int aliceScore, Map<Integer, Integer> ranking) {
        int startIndex =1;
        int endIndex = ranking.size();
        while(startIndex <= endIndex){
            int index = (endIndex + startIndex) / 2;
            int sc = ranking.get(index);
            if(aliceScore == sc){
                return index;
            }
            if(aliceScore < sc){
                startIndex = index +1;
            }
            if(aliceScore > sc){
                endIndex = index -1;
            }
        }
        return startIndex;

    }

    private static Map<Integer, Integer> getRankingFromScores(int[] scores) {
        Map<Integer, Integer> rankings = new HashMap<>();
        int pos =1;
        int preScore =-1 ;
        for(int score: scores){
            if(score!=preScore){
                rankings.put(pos, score);
                pos ++;
                preScore = score;
            }
        }
        return rankings;
    }


    public static void main(String[] args){
        int[] scores = new int[]{100, 90, 90, 80, 75, 60};
        int[] alice = new int[]{50, 65, 77, 90, 102};

        for(int score: climbingLeaderboard(scores, alice)){
            System.out.println(score);
        }

    }
}

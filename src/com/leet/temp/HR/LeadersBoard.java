package com.leet.temp.HR;

public class LeadersBoard {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] res = new int[alice.length];
        for(int i=0; i< alice.length;i++){
            res[i] = getAlicePosition(scores, alice[i]);
        }
        return res;
    }


    private static int getAlicePosition(int[] scores, int aliceScore) {
        int prevScore = -1;
        int pos =1;
        for(int score: scores){
            if(aliceScore >= score){
                return pos;
            }
            if(score != prevScore){
                prevScore = score;
                pos++;
            }
        }
        return pos;
    }

    public static void main(String[] args){
        int[] scores = new int[]{100, 90, 90, 80, 75, 60};
        int[] alice = new int[]{50, 65, 77, 90, 102};

        for(int score: climbingLeaderboard(scores, alice)){
            System.out.println(score);
        }

    }
}

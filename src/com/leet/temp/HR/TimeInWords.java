package com.leet.temp.HR;

public class TimeInWords {

    // Complete the timeInWords function below.
    static String timeInWords(int h, int m) {
        String[] minutes = {"one minute","two minutes", "three minutes", "four minutes", "five minutes",
                "six minutes","seven minutes", "eight minutes", "nine minutes", "ten minutes",
                "eleven minutes","twelve minutes", "thirteen minutes", "fourteen minutes", "quarter",
                "sixteen minutes","seventeen minutes","eighteen minutes", "nineteen minutes", "twenty minutes",
                "twenty one minutes","twenty two minutes", "twenty three minutes", "twenty four minutes", "twenty five minutes",
                "twenty six minutes","twenty seven minutes", "twenty eight minutes", "twenty nine minutes", "half"
                };
        String[] hours = {"one","two", "three", "four", "five",
                "six","seven", "eight", "nine", "ten",
                "eleven","twelve"};

        if(m>30){
            return minutes[60-m-1]+" to "+hours[h];
        }
        if(m==0){
            return hours[h-1]+" o' clock";
        }
        return minutes[m-1]+" past " + hours[h-1];

    }

    public static void main (String[] args){
        System.out.println(timeInWords(7,15)+"\n"+
        timeInWords(3,00)+"\n"+
        timeInWords(5,47)+"\n"+
        timeInWords(5,30)+"\n"+
        timeInWords(7,45));
    }
}

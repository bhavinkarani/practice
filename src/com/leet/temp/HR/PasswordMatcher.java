package com.leet.temp.HR;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordMatcher {

    public static void main (String[] args){
        System.out.println(minimumNumber(3, "Ab1"));
        System.out.println(minimumNumber(11, "#HackerRank"));
        System.out.println(minimumNumber(7, "AUzs-nV"));
    }
    static int minimumNumber(int n, String password) {
        int charCount=0;
        if (n == 0) {
            return 6;
        }
        if(!password.matches(".*[a-z]+.*")){
            charCount++;
        }
        if(!password.matches(".*[A-Z]+.*")){
            charCount++;
        }
        if(!password.matches(".*[0-9]+.*")){
            charCount++;
        }
        if(!password.matches(".*[!@#$%^&*()\\-+]+.*")){
            charCount++;
        }
        if(n+charCount<6){
           return charCount + (6 - (n+charCount));
        }
        return charCount;
    }
}

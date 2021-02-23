package com.leet.temp.HR;

public class CharToRemoveForPalindrom {

    public static void main (String[] args){
        System.out.println(palindromeIndex("aaab"));
        System.out.println(palindromeIndex("baa"));
        System.out.println(palindromeIndex("aaa"));
    }

    static int palindromeIndex(String s) {
        int index = isPalindrom(s);
        if(index==-1){
            return -1;
        }else{
           String modifiedString =   s.substring(0,index) + s.substring(index+1);
           if(isPalindrom(modifiedString)==-1){
               return index;
           }
           int j = s.length()-index-1;
           if(isPalindrom(s.substring(0,j) + s.substring(j+1))==-1){
               return j;
           }
        }
        return -1;
    }

    private static int isPalindrom(String s) {
        for(int i=0, j=s.length()-1; i< s.length()/2;i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return i;
            }
        }
        return -1;
    }
}


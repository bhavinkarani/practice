package com.leet;

public class ShuffleString {
    public static String restoreString(String s, int[] indices) {
        char[] newString = new char[s.length()];
        for(int i=0; i<indices.length; i++){
            newString[indices[i]]= s.charAt(i);
        }
        return String. valueOf(newString);
    }
    public static void main (String  args[]){
        int[] arr = new int[]{3,1,4,2,0};
        System.out.println(restoreString("aiohn", arr));
        System.out.println(restoreString2("aiohn", arr));
    }

    private static String restoreString2(String s, int[] indices) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < indices.length; i++){
            sb.setCharAt(indices[i],s.charAt(i));
        }
        return sb.toString();
    }
}

package com.leet.buk;

public class findIndex {
    public static void main(String args[]){
        int a[] = {-14,-10,2,108,108,243, 285,285,285,401, 401, 512, 704, 704, 704, 800, 800,833, 833, 833, 833, 833, 833, 833, 900, 912, 1000};
        System.out.println("^poition : "+findPos(a,833));
    }

    private static int findPos(int []a, int i) {
        int index = -1;
        int low = 0;
        int heigh  = a.length-1;
        while (heigh >= low ){
            if(a[(low+heigh)/2] > i){
                heigh = ((low+heigh)/2) -1;
            }else if(a[(low+heigh)/2] < i){
                low =((low+heigh)/2)+1;
            }else{
                index = (low+heigh)/2;
                heigh = ((low+heigh)/2) -1;
            }
            System.out.println("^^^^");
        }
        return index;
    }
}

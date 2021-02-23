package com.leet.temp.Leet;

public class MaxSumHeightIncrease {
}


class Solution1 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int sum =0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[] maxInRow = new int[rows];
        int[] maxInCol = new int[cols];
        populateMaxInRows(maxInRow, grid);
        populateMaxInCols(maxInCol, grid);
        //sum = calculateIncrease();
        return sum;
    }

    private void populateMaxInCols(int[] maxInCol, int[][] grid) {
        int i=0;
        for(int r =0; r< grid.length; r++){
            int maxHeight = 0;
            /*for(int item : row){
                if(item > maxHeight){
                    maxHeight = item;
                }
            }*/
            maxInCol[i] = maxHeight;
            i++;
        }
    }

    private void populateMaxInRows(int[] maxInRow, int[][] grid) {
        int i=0;
        for(int[] row: grid){
            int maxHeight = 0;
            for(int item : row){
                if(item > maxHeight){
                    maxHeight = item;
                }
            }
            maxInRow[i] = maxHeight;
            i++;
        }
    }



}
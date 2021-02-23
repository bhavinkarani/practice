package com.leet.temp.Leet;

public class PrintMatrixInSpiralForm {
    public static void main(String[] args) {
        new PrintMatrixInSpiralForm();
    }

    public PrintMatrixInSpiralForm() {
        int[][] matrix = {
                {1,  2,  3,  4,  5},
                {6,  7,  8,  9,  10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        int[][] matrix2 = {
                {1,  2,  3,  4,  5}
        };
        int[][] matrix3 = {
                {1},  {2},  {3},  {4},  {5}
        };

        printMatrixInSpiralWay(matrix);
        printMatrixInSpiralWay(matrix2);
        printMatrixInSpiralWay(matrix3);

        printMatrixInSpiralWayUsingRecursion(matrix,0,0,matrix[0].length-1,matrix.length-1);
        printMatrixInSpiralWayUsingRecursion(matrix2,0,0,matrix[0].length-1,matrix.length-1);
        printMatrixInSpiralWayUsingRecursion(matrix3,0,0,matrix[0].length-1,matrix.length-1);

    }

    private void printMatrixInSpiralWay(int[][] matrix) {
        int rowStart=0;
        int rowLength=matrix.length-1;

        int colStart=0;
        int colLength = matrix[0].length-1;

        while(rowStart <= rowLength &&  colStart <=colLength){

            //print top row
            for(int i=colStart; i<=colLength;i++){
                System.out.print(" "+matrix[rowStart][i]);
            }

            //print last column
            for(int i=rowStart+1; i<=rowLength;i++){
                System.out.print(" "+matrix[i][colLength]);
            }

            //print last row
            if (rowStart+1 <= rowLength){
                for(int i=colLength-1; i>=colStart; i--){
                    System.out.print(" "+matrix[rowLength][i]);
                }
            }


            //print first col bottom to top
            if (colStart+1 <= colLength) {
                for (int i = rowLength - 1; i > rowStart; i--) {
                    System.out.print(" " + matrix[i][colStart]);
                }
            }

            rowStart++;
            colStart++;
            rowLength--;
            colLength--;
        }
        System.out.println();

    }

    private void printMatrixInSpiralWayUsingRecursion(int[][] matrix, int rowStart, int colStart, int colLength,  int rowLength){
        for(int i=colStart; i<=colLength;i++){
            System.out.print(" "+matrix[rowStart][i]);
        }

        //print last column
        for(int i=rowStart+1; i<=rowLength;i++){
            System.out.print(" "+matrix[i][colLength]);
        }

        //print last row
        if (rowStart+1 <= rowLength){
            for(int i=colLength-1; i>=colStart; i--){
                System.out.print(" "+matrix[rowLength][i]);
            }
        }


        //print first col bottom to top
        if (colStart+1 <= colLength) {
            for (int i = rowLength - 1; i > rowStart; i--) {
                System.out.print(" " + matrix[i][colStart]);
            }
        }

        if(rowStart+1 <= rowLength-1 && colStart+1 <= colLength-1){
            printMatrixInSpiralWayUsingRecursion(matrix, rowStart+1, colStart+1, colLength-1, rowLength-1);
        }
    }
}

package com.leet;
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class tomtom {
    //invalid number to check if we visited the node already. 
    int invalid = Integer.MIN_VALUE;
    public int solution(int[][] A) {
        int numberOfCountries = 0;

        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                if(A[i][j]!=Integer.MIN_VALUE) {
                    numberOfCountries += markLandOfTheCountry(A, i, j, A[i][j]);
                }
            }
        }
        return numberOfCountries;
    }

    int markLandOfTheCountry(int[][] input, int i, int j, int country) {
        //lets check if we are in range and current index is visited or same country
        if(i < 0 || i >= input.length || j < 0 || j >= input[0].length || input[i][j] == invalid || input[i][j]!=country ) {
            return 0;
        }
        // To mark them visited lets assign it a number which is not in the input range
        if(input[i][j] == country) {
            input[i][j] = invalid;
        }
        // check all the neighbours if we can visit them
        markLandOfTheCountry(input, i + 1, j, country);
        //markLandOfTheCountry(input, i - 1, j, country);
        markLandOfTheCountry(input, i, j + 1, country);
        //markLandOfTheCountry(input, i, j - 1, country);

        //increment number of countries by 1
        return 1;
    }
}
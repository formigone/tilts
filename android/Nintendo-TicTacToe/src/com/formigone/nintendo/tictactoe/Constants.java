package com.formigone.nintendo.tictactoe;

public class Constants {
    private final static int[][] winningPositions = new int[][] {
	    { 0, 1, 2 },
	    { 3, 4, 5 },
	    { 6, 7, 8 },
	    { 0, 3, 6 },
	    { 1, 4, 7 },
	    { 2, 5, 8 },
	    { 0, 4, 8 },
	    { 2, 4, 6 }
    };
    
    public static int[][] getPositions() {
	return winningPositions;
    }
}

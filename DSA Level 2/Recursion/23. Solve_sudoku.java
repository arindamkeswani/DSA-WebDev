// 1. You are give a partially filled 9*9 2-D array(arr) which represents an incomplete sudoku state.
// 2. You are required to assign the digits from 1 to 9 to the empty cells following some rules.
// Rule 1 -> Digits from 1-9 must occur exactly once in each row.
// Rule 2 -> Digits from 1-9 must occur exactly once in each column.
// Rule 3 -> Digits from 1-9 must occur exactly once in each 3x3 sub-array of the given 2D array.

// Assumption -> The given Sudoku puzzle will have a single unique solution.
// Input Format
// 9*9 integers ranging from 1 to 9.
// 0 represents an empty cell.
// Output Format
// You have to print the solved sudoku.

/*
Sample Input
3 0 6 5 0 8 4 0 0
5 2 0 0 0 0 0 0 0
0 8 7 0 0 0 0 3 1
0 0 3 0 1 0 0 8 0
9 0 0 8 6 3 0 0 5
0 5 0 0 9 0 6 0 0
1 3 0 0 0 0 2 5 0
0 0 0 0 0 0 0 7 4
0 0 5 2 0 6 3 0 0
Sample Output
3 1 6 5 7 8 4 9 2 
5 2 9 1 3 4 7 6 8 
4 8 7 6 2 9 5 3 1 
2 6 3 4 1 5 9 8 7 
9 7 4 8 6 3 1 2 5 
8 5 1 7 9 2 6 4 3 
1 3 8 9 4 7 2 5 6 
6 9 2 3 5 1 8 7 4 
7 4 5 2 8 6 3 1 9 
*/

import java.io.*;
import java.util.*;

public class Main {
  public static void display(int[][] board){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[0].length; j++){
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

    public static boolean isValid(int board[][], int r, int c, int num){
        //to check if it is safe to keep a number num on that cell
        
        //Number shouldn't be in the same row, col, or 3x3 block
        
        //check row
        for(int i=r, j=0;j<=8;j++){
            if(board[i][j]==num){
                return false;
            }
        }
        //check col
        for(int i=0, j=c;i<=8;i++){
            if(board[i][j]==num){
                return false;
            }
        }
        
        //check block
        int tempR=(r/3)*3, tempC = 3*(c/3); //calculates top-left of sub-matrix/block where we will start searching for num
        for(int i=0; i<3;i++){
            for(int j=0;j<3;j++){
                if(board[tempR+i][tempC+j]==num){
                    return false;
                }
            }
        }
        return true;
    }
  public static void solveSudoku(int[][] board, int row, int col) {
    // write yopur code here
    if(row==9){ //when all rows are parsed
        display(board);
        return;
    }
    int nr,nc;
    if(col==8){ //if end of row is reached, go to next row, and first column
        nr=row+1;
        nc=0;
    }else{ //go to next column
        nr=row; 
        nc=col+1;
    }
    if(board[row][col]!=0){ //if cell is filled already, continue without modification
        solveSudoku(board, nr,nc);
    }else{
        for(int num=1;num<=9;num++){ //go through all numbers
            if(isValid(board, row, col, num)){ //check if all conditions for number are met
                board[row][col] = num;     //place num in cell
                solveSudoku(board, nr,nc); //check next cell
                board[row][col] = 0;     //backtrack to check other answers 
            }
            
        }
    }
    
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    solveSudoku(arr, 0, 0);
  }
}

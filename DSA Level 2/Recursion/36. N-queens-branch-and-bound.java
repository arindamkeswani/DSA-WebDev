// 1. You are given a number n, the size of a chess board.
// 2. You are required to place n number of queens in the n * n cells of board such that no queen can 
//      kill another.
// Note - Queens kill at distance in all 8 directions
// 3. Complete the body of printNQueens function - without changing signature - to calculate and 
//      print all safe configurations of n-queens

// Use sample input and output to get more idea.

// Note -> The online judge can't force you to write the function recursively but that is what the spirit 
//                of question is.

// Write recursive and not iterative logic. The purpose of the question is to aid learning recursion, branch and bound technique and not test you.
// Input Format
// A number n
// Output Format
// Safe configurations of queens as suggested in sample output

/*
Sample Input
4
Sample Output
0-1, 1-3, 2-0, 3-2, .
0-2, 1-0, 2-3, 3-1, .
*/

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    // boolean[][] board = new boolean[n][n]; //We dont need board for this approach
    //write your code here
    nqueens(0, new boolean[n], new boolean[2*n-1],new boolean[2*n-1],"" );
  }
    
    public static void nqueens(int row, boolean visitedCols[], boolean visitedNDiag[], boolean visitedRDiag[],String asf ){
        int n= visitedCols.length;
        
        //i-j + (n-1) :Normal diagonal //this formula refers to all the cells in the same diagnoal
        //i+j :reverse diagnal //"" "" "" in the same reverse diagonal
        
        if(row==n){
            System.out.println(asf+".");
            return;
        }
        
        for(int c=0;c<n;c++){ //tarversing columns
            if(isSafe(row, c, visitedCols, visitedNDiag, visitedRDiag)){
                //mark as visited
                visitedCols[c]=true;
                visitedNDiag[row-c+(n-1)]=true; 
                visitedRDiag[row+c]=true;
                
                //add answer to asf and go to next row 
                nqueens(row+1, visitedCols, visitedNDiag, visitedRDiag, asf+row+"-"+c+", ");
                
                //mark as unvisited
                visitedCols[c]=false;
                visitedNDiag[row-c+(n-1)]=false;
                visitedRDiag[row+c]=false;
            }
            
            
        }
       
    }
    
    public static boolean isSafe(int row, int col, boolean visitedCols[], boolean visitedNDiag[], boolean visitedRDiag[]){
        int n= visitedCols.length;
        //check is all values in same column, diagonal, and reverse diagonal are unvisited, only then can queen be placed
        return visitedCols[col]==false && visitedNDiag[row-col+n-1]==false && visitedRDiag[row+col]==false;
    }
}
// Given a cost matrix cost[][] and a position (m, n) in cost[][],
// write a function that returns cost of minimum cost path to reach (m, n) from (0, 0).
// Each cell of the matrix represents a cost to traverse through that cell. Total
// cost of a path to reach (m, n) is sum of all the costs on that path
// (including both source and destination). You can only traverse down, right and
// diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells
// (i+1, j), (i, j+1) and (i+1, j+1) can be traversed. You may assume that all
// costs are positive integers.


// Example

// Input:
// 3 3
// 1 2 3
// 4 8 2
// 1 5 3

// Output:
// 8
// Input Format

// First Line Of input is no. of rows and columns.
// which is followed by its input in Positive integer.
// Constraints

// 0< row,col <1000
// 0< a[i] < 1000
// Output Format

// Print output(min cost).
// Sample Input 0

// 3 3
// 1 2 3
// 4 8 2
// 1 5 3
// Sample Output 0

// 8


import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner x= new Scanner(System.in);
        int m=x.nextInt();
        int n=x.nextInt();
        
        int arr[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = x.nextInt();
            }
        }
        int dp[][] = new int[m][n];
        
        
        for(int r = m-1; r>=0;r--){
            for(int c = n-1; c>=0;c--){
                if(r==m-1 && c==n-1){ //if at destination(starting point)
                    dp[r][c] = arr[r][c];
                }else{
                    
                    if(r==m-1){ //if in last row, just calculate row value
                        dp[r][c] = arr[r][c] + dp[r][c+1];
                    }
                    else if(c==n-1){ //if in last col, just calculate col value
                        dp[r][c] = arr[r][c] + dp[r+1][c];
                    }else{ //middle block, min of down and right cells and (down + right[for diagonal])
                        dp[r][c] = arr[r][c] + Math.min(dp[r+1][c+1] , Math.min(dp[r+1][c], dp[r][c+1]));
                    }
                }
            }
        }
        
        System.out.println(dp[0][0]);
    }
}
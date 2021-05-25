// 1. You are given a number n, representing the number of rows.
// 2. You are given a number m, representing the number of columns.
// 3. You are given n*m numbers, representing elements of 2d array a, which represents a maze.
// 4. You are standing in top-left cell and are required to move to bottom-right cell.
// 5. You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
// 6. Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom- 
//      right cell).
// 7. You are required to traverse through the matrix and print the cost of path which is least costly.
// Input Format
// A number n
// A number m
// e11
// e12..
// e21
// e22..
// .. n * m number of elements
// Output Format
// The cost of least costly path.


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner x= new Scanner(System.in);
        int n=x.nextInt();
        int m=x.nextInt();
        
        int arr[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j] = x.nextInt();
            }
        }
        
        System.out.println(minCostMazeTraversal(n,m,arr));
    }
    
    public static int minCostMazeTraversal(int n,int m,int arr[][]){
        
        
        int dp[][] = new int[n][m];
        
        for(int r = n-1; r>=0;r--){
            for(int c = m-1; c>=0;c--){
                if(r==n-1 && c==m-1){ //if at destination(starting point)
                    dp[r][c] = arr[r][c];
                }else{
                    
                    if(r==n-1){ //if in last row, just calculate row value
                        dp[r][c] = arr[r][c] + dp[r][c+1];
                    }
                    else if(c==m-1){ //if in last col, just calculate col value
                        dp[r][c] = arr[r][c] + dp[r+1][c];
                    }else{ //middle blocl, min of down and right cells
                        dp[r][c] = arr[r][c] + Math.min(dp[r+1][c], dp[r][c+1]);
                    }
                }
            }
        }
        
        return dp[0][0];
        
    }
}
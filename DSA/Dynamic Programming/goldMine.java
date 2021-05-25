// 1. You are a given a gold mine's grid, where each positive integer represents units of gold in that place
//  2. You are initially in the left most coloumn (it can be any row), you can move in 3 ways:
//      a) Diagonally up towards right
//      b) Right
//      c) Diagonally down towards right
//  3. Find and return maximum gold you can collect
//  4. Input and output is handled for you
//  5. It is a functional problem ,please do not modify main()
// Input Format
// Input is handled for you
// Output Format
// Output is handled for you

import java.util.*;
 import java.io.*;
 class Main
 {
     public static void main (String[] args)
 	  {
 	      Scanner sc = new Scanner(System.in);
 	         int n = sc.nextInt();
 	         int m = sc.nextInt();
 	         int[][] a = new int[n][m];
 	         for(int i = 0; i < n; i++){
 	             for(int j = 0; j < m; j++) {
 	                 a[i][j] = sc.nextInt();
 	             }
             }
             System.out.println(function(a, n, m));
 	      }
 	  	 // -----------------------------------------------------
 	 // This is a functional problem. Only this function has to be written.
 	 // This function takes as input a 2D integer array and 2 integers
 	 // It should return the required output
 
 	  static int function(int[][] a,int n, int m){
 	    //Write your code here
 	    int dp[][] = new int[n][m];
        
        //traversal will be column wise
        
        for(int j=m-1;j>=0;j--){
            for(int i=0; i<n;i++){
                if(j==m-1){ //in last column, values are as they are
                    dp[i][j] = a[i][j];
                }else{
                    if(n==1){ //if there is only one row
                        dp[i][j] = a[i][j]+dp[i][j+1];
                    }
                    else if(i==0){ //in first row, only right and bottom right can be done
                        dp[i][j] = a[i][j]+ Math.max(dp[i+1][j+1], dp[i][j+1]);
                    }else if(i==n-1){ //in last row, only right and up right can be done
                        dp[i][j] = a[i][j]+Math.max(dp[i-1][j+1], dp[i][j+1]);
                    }else{ //test all 3
                        dp[i][j] = a[i][j]+Math.max(dp[i-1][j+1], Math.max(dp[i][j+1] , dp[i+1][j+1]) );
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            if(dp[i][0]>max){
                max=dp[i][0];
            }
        }
        
        return max;
 	 }
 }

 //altenate
 public static int maxGold(int mine[][]){
    int nr = mine.length , nc = mine[0].length;
    int dp[][] = new int[nr][nc];
    
    for(int c = nc-1 ; c>=0 ; c--){
        for(int r = 0 ; r < nr ; r++){
            if(c == nc-1){
                dp[r][c] = mine[r][c];
            }else{
                int du = (r-1 >= 0) ? dp[r-1][c+1] : 0;
                int dd = (r+1 < nr) ? dp[r+1][c+1] : 0;
                dp[r][c] = Math.max(dp[r][c+1],Math.max(du,dd))+mine[r][c];
            }
        }
    }
    
    int max = Integer.MIN_VALUE;
    for(int r = 0 ; r < nr ;r++){
        max = Math.max(max,dp[r][0]);
    }
    
    return max;
}
public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int nr = scn.nextInt() , nc = scn.nextInt();
    
    int mine[][] = new int[nr][nc];
    for(int i = 0 ; i < nr ; i++){
        for(int j = 0 ; j < nc ; j++){
            mine[i][j] = scn.nextInt();
        }
    }
    
    System.out.println(maxGold(mine));
}

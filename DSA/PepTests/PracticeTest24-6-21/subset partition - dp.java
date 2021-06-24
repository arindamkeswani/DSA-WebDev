// 1. You are given a number n, representing the number of elements.
// 2. You are given a number k, representing the number of subsets.
// 3. You are required to print the number of ways in which these elements can be partitioned in k non-empty subsets.
// E.g.
// For n = 4 and k = 3 total ways is 6
// 12-3-4
// 1-23-4
// 13-2-4
// 14-2-3
// 1-24-3
// 1-2-34
// Input Format

// A number n
// A number k
// Constraints

// 0 <= n <= 20
// 0 <= k <= n
// Output Format

// A number representing the number of ways in which these elements can be partitioned in k non-empty subsets.
// Sample Input 0

// 4
// 3
// Sample Output 0

// 6
// Sample Input 1

// 2
// 1
// Sample Output 1

// 1

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner x=new Scanner(System.in);
        int n=x.nextInt();
        int k=x.nextInt();
        
        long dp[][]=new long[n+1][k+1];
        
        if(n==0 || k==0|| n<k){
            System.out.print(0);
            return;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                if(j==1||i==j){ //in these cases there is only one way of partitioning them
                    dp[i][j] = 1;
                }else{
                    dp[i][j]=j*dp[i-1][j] + dp[i-1][j-1]; //When new person is eval, either they are included, which leads to j times more combinations, + , they can be excluded, so same as before will be added
                }
            }
            
        }
        // for(int i=0;i<=n;i++){
        //     for(int j=0;j<=k;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
        System.out.println(dp[dp.length-1][dp[0].length-1]);
        
    }
}
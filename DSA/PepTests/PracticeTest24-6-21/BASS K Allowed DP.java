// 1. You are given a number n, representing the number of days.
// 2. You are given n numbers, where ith number represents price of stock on ith day.
// 3. You are given a number k, representing the number of transactions allowed.
// 3. You are required to print the maximum profit you can make if you are allowed k transactions at-most.
// Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
// Input Format

// A number n
// .. n more elements
// A number k
// Constraints

// 0 <= n <= 20
// 0 <= n1, n2, .. <= 10
// 0 <= k <= n / 2
// Output Format

// A number representing the maximum profit you can make if you are allowed a single transaction.
// Sample Input 0

// 6
// 9
// 6
// 7
// 6
// 3
// 8
// 1
// Sample Output 0

// 5

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner x= new Scanner(System.in);
        int n=x.nextInt();
        int a[]=new int[n];
        
        for(int i=0;i<n;i++){
            a[i] = x.nextInt();
        }
        int k=x.nextInt();
        
        long dp[][] = new long[k+1][n];
        
        //Transactions done any where between day 0 and (j-1) need to be compared to each other, and to the value of transaction of one day before current,
        // where same number of transactions have already been done. 
        //Best one is selected

        for(int i=1;i<=k;i++){ 
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i][j-1]; //Case where curr level of Transactions were completed a day before itself
                for(int l=0;l<j;l++){
                    dp[i][j] = Math.max(dp[i-1][l]+ a[j] - a[l],dp[i][j]); //case where (0 to j-1) days' values + (if stock bought on day l was sold today )
                }
                
            }
        }
        // for(int i=0;i<=k;i++){
        //     for(int j=0;j<n;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        System.out.println(dp[k][n-1]);
    }
}
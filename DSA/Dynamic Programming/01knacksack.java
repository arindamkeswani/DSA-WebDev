// 1. You are given a number n, representing the count of items.
// 2. You are given n numbers, representing the values of n items.
// 3. You are given n numbers, representing the weights of n items.
// 3. You are given a number "cap", which is the capacity of a bag you've.
// 4. You are required to calculate and print the maximum value that can be created in the bag without 
//      overflowing it's capacity.

// Note -> Each item can be taken 0 or 1 number of times. You are not allowed to put the same item 
//                again and again.
// Input Format
// A number n
// v1 v2 .. n number of elements
// w1 w2 .. n number of elements
// A number cap
// Output Format
// A number representing the maximum value that can be created in the bag without overflowing it's capacity

iimport java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner x= new Scanner(System.in);
        int n= x.nextInt();
        int v[]=new int[n];
        int w[]=new int[n];
        
        for(int i=0;i<n;i++){
            v[i]=x.nextInt();
        }
        for(int i=0;i<n;i++){
            w[i]=x.nextInt();
        }
        
        int cap=x.nextInt();
        
        knapsack(v,w,cap,n);
    }
    
    public static void knapsack(int v[], int w[], int cap, int n){
        int dp[][] = new int[n+1][cap+1];
        
        for(int i=1;i<=n;i++){ //starting from 1 because we want to avoi dinitial row and columns
            int wt = w[i-1]; //weight of current row
            int val = v[i-1]; //value in current row
            for(int j=1;j<=cap;j++){
                int excl = dp[i-1][j]; //if we were excluding current val
                int inc = j-wt>=0 ? (val + dp[i-1][j-wt]) : 0; //if we were including current weight (if capacity allows)
                dp[i][j]= Math.max(excl, inc); //get max of both values
                
            }
        }
        
        // for(int i=0;i<=n;i++){
        //     for(int j=0;j<=cap;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
        System.out.println(dp[n][cap]);
    }
}
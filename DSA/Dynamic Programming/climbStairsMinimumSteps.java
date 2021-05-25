// 1. You are given a number n, representing the number of stairs in a staircase.
// 2. You are on the 0th step and are required to climb to the top.
// 3. You are given n numbers, where ith element's value represents - till how far from the step you 
//      could jump to in a single move.  You can of-course fewer number of steps in the move.
// 4. You are required to print the number of minimum moves in which you can reach the top of 
//      staircase.
// Note -> If there is no path through the staircase print null.
// Input Format
// A number n
// .. n more elements
// Output Format
// A number representing the number of ways to climb the stairs from 0 to top.

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        int a[]= new int[n];
        
        for(int i=0;i<n;i++){
            a[i] = x.nextInt();
        }
        long steps = climbMinCost(n, a);
        if(steps==Integer.MAX_VALUE){
            System.out.println("null");
        }
        else{
            System.out.println(steps);
        }
    }
    
    public static long climbMinCost(int n, int a[]){
        long dp[] = new long[n+1];
        
        
        for(int i=n;i>=0;i--){
            if(i==n){
                dp[n] = 0; //since it is at the destination already
            }else{
                int maxJmp = a[i];
                if(maxJmp ==0 ){ //cannot move anywhere
                    dp[i] = Integer.MAX_VALUE;
                }
                else{
                    long temp=Integer.MAX_VALUE; //to store minimum value from all jumps
                    for(int j=1;j<=maxJmp && j+i <=n ;j++){ //j repr curr jump value from index
                        if(dp[i+j]!=Integer.MAX_VALUE){
                            temp = Math.min(temp, dp[i+j]);
                        }
                        
                    }
                    dp[i] = temp + 1;
                    
                    //  for(int k=0;k<n+1;k++){
                    //     System.out.print(dp[k]+" ");
                    // }
                    // System.out.println("|JMP="+a[i] +" i="+i+"maxjmp="+maxJmp);
                }
                
            }
        }
        
        // for(int i=0;i<n+1;i++){
        //     System.out.print(dp[i]+" ");
        // }
        return dp[0];
    }
}
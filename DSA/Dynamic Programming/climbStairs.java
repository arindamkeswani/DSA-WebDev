// 1. You are given a number n, representing the number of stairs in a staircase.
// 2. You are on the 0th step and are required to climb to the top.
// 3. In one move, you are allowed to climb 1, 2 or 3 stairs.
// 4. You are required to print the number of different paths via which you can climb to the top.
// Input Format
// A number n
// Output Format
// A number representing the number of ways to climb the stairs from 0 to top.


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner x= new Scanner(System.in);
        int n=x.nextInt();
        System.out.println(climb(n));
    }
    
    public static int climb(int n){
        int c=0;
        int m[] = {1,2,3};
        int dp[]=new int[n+1];
        
        if(n<=1){
            return 1;
        }
        
        if(n==2){
            return 2;
        }
        
        if(n==3){
            return 4;
        }
        
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        
        for(int i=4;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }
}
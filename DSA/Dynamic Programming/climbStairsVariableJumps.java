// 1. You are given a number n, representing the number of stairs in a staircase.
// 2. You are on the 0th step and are required to climb to the top.
// 3. You are given n numbers, where ith element's value represents - till how far from the step you 
//      could jump to in a single move.  
//      You can of course jump fewer number of steps in the move.
// 4. You are required to print the number of different paths via which you can climb to the top.
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
        Scanner x= new Scanner(System.in);
        int n=x.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = x.nextInt();
        }
        
        System.out.println(climbVar(n, a));
    }
    public static int climbVar(int n, int a[]){
        int dp[] = new int[n+1];
        
        dp[0]=1;
        
        for(int i=0;i<n;i++){
            for(int j=1;j<=a[i];j++){
                if(i+j<=n){
                    dp[i+j] += dp[i];
                }
                
            }
        }
        
        // for(int i=0;i<dp.length; i++){
        //     System.out.println(dp[i]);
        // }
        return dp[n];
    }
}


________________________________
//top down approach

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner x= new Scanner(System.in);
        int n=x.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = x.nextInt();
        }
        
        System.out.println(climbVar(n, a));
    }
    public static int climbVar(int n, int a[]){
        int dp[] = new int[n+1];
        
        //top down approach
        
        for(int i=n;i>=0;i--){
            if(i==n){
                dp[n]=1; //base case
            }
            else{
                int maxJmp = a[i];
                if(maxJmp ==0 ){
                    dp[i]=0;
                }
                else{
                    for(int jmp=1;jmp<=maxJmp && jmp+i<=n; jmp++){
                        dp[i]+=dp[i+jmp];
                    }
                }
            }
        }
        
        return dp[0];
        
    }
}
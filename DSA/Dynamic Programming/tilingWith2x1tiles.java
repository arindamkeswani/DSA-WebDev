// 1. You are given a number n representing the length of a floor space which is 2m wide. It's a 2 * n board.
// 2. You've an infinite supply of 2 * 1 tiles.
// 3. You are required to calculate and print the number of ways floor can be tiled using tiles.
// Input Format
// A number n
// Output Format
// A number representing the number of ways in which the number of ways floor can be tiled using tiles.


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        
        int a=1; //ways to put tiles in zero space
        int b=1; //ways to put tiles in 1m space
        
        int dp[]=new int[n+1];
        dp[0]=1; //ways to put tiles in zero space
        dp[1]=1; //ways to put tiles in 1m space
        
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2]; //previous vertical + horizontal configs
        }
        
        System.out.println(dp[n]);
    }
}
////////////////////Optimised//////////////////////////

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        
        int a=1; //ways to put tiles in zero space
        int b=1; //ways to put tiles in 1m space
        
        // int dp[]=new int[n+1];
        // dp[0]=1; //ways to put tiles in zero space
        // dp[1]=1; //ways to put tiles in 1m space
        int c=0;
        for(int i=2;i<=n;i++){
            // dp[i] = dp[i-1] + dp[i-2]; //previous vertical + horizontal configs
            c= a+b;
            
            a=b;
            b=c;
        }
        
        System.out.println(c);
    }
}

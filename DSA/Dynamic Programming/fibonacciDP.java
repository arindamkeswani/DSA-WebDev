// 1. You are given a number n.
// 2. You are required to print the nth element of fibonnaci sequence.

// Note -> Notice precisely how we have defined the fibonnaci sequence
// 0th element -> 0
// 1st element -> 1
// 2nd element -> 1
// 3rd element -> 2
// 4th element -> 3
// 5th element -> 5
// 6th element -> 8




import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner x=new Scanner(System.in);
    int n= x.nextInt();
    System.out.println(fiboDP(n));
 }
    public static int fiboDP(int n){
        int dp[]= new int[n+1];
        
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        dp[0]=0; dp[1]=1;
        
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1] + dp[i-2];
        }
        
        return dp[n];
    }

    fiboR()
}
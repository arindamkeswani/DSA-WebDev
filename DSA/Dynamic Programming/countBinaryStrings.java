// 1. You are given a number n.
// 2. You are required to print the number of binary strings of length n with no consecutive 0's.
// Input Format
// A number n
// Output Format
// A number representing the number of binary strings of length n with no consecutive 0's.



import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner x=new Scanner(System.in);
    int n = x.nextInt();
    
    int dp[][] = new int[2][n+1];
    
    // for(int len=1;len<=n;len++){
    //     if(len==1){
    //         dp[0][1]=1;
    //         dp[1][1]=1;
    //     }else{
    //         dp[0][len]=dp[1][len-1];
    //         dp[1][len]=dp[1][len-1] + dp[0][len-1];
    //     }
    // }
    
    // System.out.println(dp[0][n]+dp[1][n]);
    
    int countEnd0=1;
    int countEnd1=1;
    for(int len=2;len<=n;len++){
        int t0 = countEnd1;
        int t1 = countEnd1 + countEnd0;
        
        countEnd0=t0;
        countEnd1=t1;
    }
    
    System.out.println(countEnd0+countEnd1);
 }

}
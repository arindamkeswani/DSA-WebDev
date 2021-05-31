// 1. You are given a number n and a number m separated by line-break representing the length and breadth of a n * m floor.
// 2. You've an infinite supply of m * 1 tiles.
// 3. You are required to calculate and print the number of ways floor can be tiled using tiles.
// Input Format
// A number n
// A number m
// Output Format
// A number representing the number of ways in which the number of ways floor can be tiled using tiles.



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner x=new Scanner(System.in);
        int n = x.nextInt();
        int m = x.nextInt();
        
        int dp[]=new int[n+1];
        
        for(int i=0;i<=n;i++){
            if(i==0){
                dp[0] = 1; //base
            }else if(i<m){
                dp[i] = 1; //only horizontal
            }else if(n==m){
                dp[i]=2; //one way for vert + one way for horizontal
            }
            else{
                dp[i] = dp[i-1]+dp[i-m]; //horizontal + vertical config
            }
        }
        
        System.out.println(dp[n]);
    }
}
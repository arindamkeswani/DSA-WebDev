// 1. You are given a number n, representing the count of items.
// 2. You are given n numbers, representing the values of n items.
// 3. You are given n numbers, representing the weights of n items.
// 3. You are given a number "cap", which is the capacity of a bag you've.
// 4. You are required to calculate and print the maximum value that can be created in the bag without 
//     overflowing it's capacity.
// Note -> Each item can be taken any number of times. You are allowed to put the same item again 
//                   and again.
// Input Format
// A number n
// v1 v2 .. n number of elements
// w1 w2 .. n number of elements
// A number cap
// Output Format
// A number representing the maximum value that can be created in the bag without overflowing it's capacity
import java.io.*;
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
        
        unboundedKnapsack(v,w,cap,n);
    }
    
    public static void unboundedKnapsack(int v[], int w[], int cap, int n){
       
       int dp[] = new int[cap+1];
        //we traverse every single weight/value pair, and inside we will go through 0 to cap
        
        
        dp[0]=0;
        for(int bagc=1;bagc<=cap;bagc++){
            int max=0;
            for(int i=0;i<n;i++){
                
                if(w[i]<=bagc){
                    int rbagc = bagc-w[i];
                    int rbagv = dp[rbagc];
                    int tbagval = rbagv+v[i];
                    
                    max=Math.max(max, tbagval);
                }
            }
            
            dp[bagc]=max;
        }
        
       // for(int i=0;i<n;i++ ){ //go through each weight
       //     int wt = w[i];
       //     int val = v[i];
            
       //     for(int j=0;i<=cap;j++){ //go through each possible weight and see max value that curent weight can get for respective capacity
       //         if(j==0){
       //             dp[j]=0;
       //            // System.out.println("IN1");
       //         }else{
       //            // System.out.println("IN");
       //             int exc = dp[j];
       //             int incl = (j-wt>=0) ? (val+ dp[j-wt]) : 0;
       //             System.out.println("INC:"+incl);
       //             dp[j] = Math.max(exc, incl);
       //         }
       //     }
       // }
        
       // for(int i=0;i<n;i++){
       //     System.out.print(dp[i]+" ");
       // }
        System.out.println(dp[cap]);
    }
}
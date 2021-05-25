// 1. You are given a number n, representing the count of coins.
// 2. You are given n numbers, representing the denominations of n coins.
// 3. You are given a number "amt".
// 4. You are required to calculate and print the number of combinations of the n coins using which the 
//      amount "amt" can be paid.

// Note1 -> You have an infinite supply of each coin denomination i.e. same coin denomination can be 
//                   used for many installments in payment of "amt"
// Note2 -> You are required to find the count of combinations and not permutations i.e.
//                   2 + 2 + 3 = 7 and 2 + 3 + 2 = 7 and 3 + 2 + 2 = 7 are different permutations of same 
//                   combination. You should treat them as 1 and not 3.
// Input Format
// A number n
// n1
// n2
// .. n number of elements
// A number amt
// Output Format
// A number representing the count of combinations of coins which can be used to pay the amount "amt"



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner x= new Scanner(System.in);
        int n=x.nextInt();
        
        int a[]= new int[n];
        for(int i=0;i<n;i++){
            a[i] = x.nextInt();
        }
        int amt = x.nextInt();
        
        coinChangeComb(n,a,amt);
    }
    
    public static void coinChangeComb(int n,int a[],int amt){
        int dp[] = new int[amt + 1];
        
        dp[0]=1; //base case
        
        for(int i=0;i<n;i++){ //traverse all deniminations available one at a time
            int coin = a[i];  // pick current denomination 
            for(int j=coin; j<=amt; j++){ //taking from "coin" index instead of zero to prevent permutation
                dp[j] += dp[j-coin]; //add no. of ways that the sum can be calculated with using current coin
            }
        }
        System.out.println(dp[amt]);
    }
}
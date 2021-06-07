// 1. You are given a number n, representing the number of days.
// 2. You are given n numbers, where ith number represents price of stock on ith day.
// 3. You are required to print the maximum profit you can make if you are allowed a single transaction.
// Input Format
// A number n
// .. n more elements
// Output Format
// A number representing the maximum profit you can make if you are allowed a single transaction.


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner x = new Scanner(System.in);
        int n=x.nextInt();
        
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i] = x.nextInt();
        }
        
        int buy = a[0]; //current buy value
        int sell = a[0]; //current sell value
        int prof = 0; //max profit till date
        
        for(int i=0;i<n;i++){ //traverse through the days
            sell = a[i]; //current day is potential selling point
            if(sell-buy<0){ //is profit is negative, define new lowest buy point
                buy=a[i];
            }
            
            if(sell-buy>prof){ //if new max profit found, store it
                prof = sell-buy;
            }
        }
        
        System.out.println(prof); //print maximum profit
    }

}
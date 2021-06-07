// 1. You are given a number n, representing the number of days.
// 2. You are given n numbers, where ith number represents price of stock on ith day.
// 3. You are required to print the maximum profit you can make if you are allowed infinite transactions.
// Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy)
// Input Format
// A number n
// .. n more elements

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner x= new Scanner(System.in);
        int n=x.nextInt();
        int a[]=new int[n];
        
        for(int i=0;i<n;i++){
            a[i] = x.nextInt();
        }
        
        int buy=a[0];
        int sell=a[0];
        int prof = 0;
        
        for(int i=0;i<n;i++){  
            sell=a[i];
            if(sell - buy<0){ //if going in a loss
                buy=a[i]; //new buy point is current day
            }
            else{ //if we are making a profit by selling shares from previous day
                prof += sell - buy; //add profit
                buy=a[i]; //shift buy day to current day
            }
        }
        
        System.out.println(prof);
    }

}
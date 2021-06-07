// 1. You are given a number n, representing the number of days.
// 2. You are given n numbers, where ith number represents price of stock on ith day.
// 3. You are required to print the maximum profit you can make if you are allowed infinite transactions, but have to cooldown for 1 day after 1 transaction
// i.e. you cannot buy on the next day after you sell, you have to cooldown for a day at-least before buying again.
// Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
// Input Format
// A number n
// .. n more elements
// Output Format
// A number representing the maximum profit you can make if you are allowed infinite transactions with cooldown of 1 day.


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
        // int fee=x.nextInt();
        
        
        int oBSP = 0; //old buying state profit
        int oSSP = 0; //old selling state profit
        int oCSP = 0; //cooldown state profit
        
        for(int day=0;day<n;day++){ 
            if(day==0){ //assign loan if buying on day 0
                oBSP = -a[day];
            }
            else{
                int nBSP = Math.max(oBSP, oCSP - a[day]); //new buying state prof = either previous buying state, or previous cooldown state - price of the day, whichever is better
                //understand this by treating oCSP as oSSP from prev question (oSSP is out of picture because of cooldown)
                int nSSP = Math.max(oSSP, a[day] + oBSP); //new selling state profit = either previous selling state profit, or price of the day - loan, whichever is better
                int nCSP = oSSP; //cooldown state profit = previous selling state in the case that we sell on the previous day
                
                oBSP = nBSP;
                oSSP = nSSP;
                oCSP = nCSP;
            }
            
        }
        
        System.out.println(oSSP);
    }
    

}
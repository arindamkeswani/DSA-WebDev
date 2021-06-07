// 1. You are given a number n, representing the number of days.
// 2. You are given n numbers, where ith number represents price of stock on ith day.
// 3. You are give a number fee, representing the transaction fee for every transaction.
// 4. You are required to print the maximum profit you can make if you are allowed infinite transactions, but has to pay "fee" for every closed transaction.
// Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
// Input Format
// A number n
// .. n more elements
// A number fee
// Output Format
// A number representing the maximum profit you can make if you are allowed infinite transactions with transaction fee.



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
        int fee=x.nextInt();
        
        
        int oBSP = 0; //old buying state profit
        int oSSP = 0; //old selling state profit
        
        for(int day=0;day<n;day++){
            if(day==0){ 
                oBSP = -a[day]; //loan value is we buy on day 0
            }else{
                int nBSP = Math.max(oSSP - a[day], oBSP); //either we choose loan = previous selling state profit - current day price, or previous day loan, whichever is better
                int nSSP = Math.max(oSSP , a[day] -fee + oBSP); //either we choose previous selling state profit, or if we choose to sell today, check if removing transaction free and loan from it will be better or not
                oBSP = nBSP; // update values
                oSSP = nSSP;
            }
            
            
        }
        
        System.out.println(oSSP);
        
        
        
    //     int buy[] = new int[n];
    //     int sell[] = new int[n];
        
    //     int prof = 0;
    //     int sell[0]=a[0];
    //     int buy[0]=prof-a[0];
        
        
    //     for(int i=1;i<n;i++){
    //         int buyState = Math.max(buy[i-1] , a[i]-sell[i]);
            
    //     }
    }

}
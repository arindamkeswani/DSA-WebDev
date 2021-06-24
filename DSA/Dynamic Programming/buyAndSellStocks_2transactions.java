// 1. You are given a number n, representing the number of days.
// 2. You are given n numbers, where ith number represents price of stock on ith day.
// 3. You are required to print the maximum profit you can make if you are allowed two transactions at-most.
// Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
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
        Scanner x= new Scanner(System.in);
        int n=x.nextInt();
        int a[]=new int[n];
        
        for(int i=0;i<n;i++){
            a[i] = x.nextInt();
        }
        
        //find a point in the array before which we need to complete one transaction and get max profit till then, and same for after that point
        
        int mpist = 0; //max profit if sold today (for left half)
        int leastsf =a[0]; //least so far, to  determine buying point
        int mpsut[] = new int[n] ; //maximum profit sold upto today
        for(int i=1;i<n;i++){
            if(a[i]<leastsf){ //update value of lowest buying value so far
                leastsf = a[i];
            }
            
            mpist = a[i] - leastsf; 
            if(mpist> mpsut[i-1]){ //if profit (on selling today) is more than previous, update value. Don't if not.
                mpsut[i] = mpist;
            }else{
                mpsut[i] = mpsut[i-1];
            }
            
        }
        
        int mpibt = 0; ////max profit if bought today(for right half)
        int maxat=a[n-1]; //max after today
        int mpbut[] = new int[n] ; //maximum profit in the future if bought today
        for(int i=n-2;i>0;i--){
            if(a[i]>maxat){ //update maximum selling point of the future if noting down today
                maxat = a[i]; 
            }
            
            mpibt = maxat - a[i]; //if profit (on selling today) is more than future ones, update value. Don't if not.
            if(mpibt> mpbut[i+1]){
                mpbut[i] = mpibt;
            }else{
                mpbut[i] = mpbut[i+1];
            }
            
        }
        
        int combProf = 0;
        for(int i=0;i<n;i++){ //check which combination of transactions gives highest profits
            int temp = mpsut[i] + mpbut[i];
            if(temp>combProf){
                combProf=temp;
            }
            
        }
        
        System.out.println(combProf);
    }

}
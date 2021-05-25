// 1. You are given a number n, representing the count of elements.
// 2. You are given n numbers.
// 3. You are given a number "tar".
// 4. You are required to calculate and print true or false, if there is a subset the elements of which add 
//      up to "tar" or not.
// Input Format
// A number n
// n1
// n2
// .. n number of elements
// A number tar
// Output Format
// true or false as required



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner x=new Scanner(System.in);
        int n = x.nextInt();
        
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = x.nextInt();
        }
        
        int t= x.nextInt();
        
        tarSumSubset(n,a,t);
        
    }
    
    public static void tarSumSubset(int n,int a[],int t){
        //dp of (n+1)(tar+1) is created
        //Each row represents value of corresponding value of row in a, and all values of rows before it
        //columns repre target value
        //cell value is whether target value can be achieved by all row alues before and equal to current row
        //first row is false (0 cannot pay for any targets)
        //first col is true (as payment of zero can always be made)
        
        //check if including coin will contribute to target, if no, check what not including it obtained
        //if coin not included, check one row above for value which is same as not inc coin
        //if coin in included, check one row above, col= cell target - coin
        
        boolean dp[][] = new boolean[n+1][t+1];
        
        for(int r=0;r<n+1;r++){
            for(int c=0;c<=t;c++){
                if(r==0 && c==0){
                    dp[r][c] = true;
                }else if(r==0){
                    dp[r][c] = false;
                }
                else if(c==0){
                    dp[r][c] = true;
                }else{
                    int coin = a[r-1]; //get coin value of current row
                    boolean exc = dp[r-1][c];
                    boolean inc = (c-coin>=0) ? dp[r-1][c-coin] : false;
                    dp[r][c] = exc || inc;
                }
            }
        }
        
        System.out.println(dp[n][t]);
        
    }
}
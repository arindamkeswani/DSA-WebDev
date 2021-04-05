// 1. You are given a number n, representing the count of elements.
// 2. You are given n numbers.
// 3. You are required to print all subsets of arr. Each subset should be
// on separate line. For more clarity check out sample input and output.

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner x=new Scanner(System.in);
        int n=x.nextInt();
        int[] arr=new int[n];
        
        for(int i=0;i<n;i++){
            arr[i]=x.nextInt();
        }
        
        int lim=1;
        for(int i=0;i<n;i++){
            lim*=2;
        }
        
        
        for(int i=0;i<lim;i++){
            int temp=i;
            String set="";
            for(int j=arr.length-1;j>=0;j--){
                
                int r=temp%2;
                temp/=2;
                
                if(r==0){
                    set="-	" + set;
                }
                else{
                    set=arr[j]+"	" + set;   
                }
            }
            System.out.println(set);
        }
        
    }

}
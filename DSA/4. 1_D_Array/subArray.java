// 1. You are given an array of size 'n' and n elements of the same array.
// 2. You are required to find and print all the subarrays of the given array. 
// 3. Each subarray should be space seperated and on a seperate lines. Refer to sample input and output.

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner x = new Scanner(System.in);
        
        int n=x.nextInt();
        
        int[] arr=new int[n];
        
        for(int i=0;i<n;i++){
            arr[i]=x.nextInt();
        }
        
            int p=0;
            // for(int k=p;k<n;k++){
            //     for(int i=k;i<n;i++){
            //         for(int j=k;j<=i;j++){
            //             System.out.print(arr[j]+"	");
            //         }
            //         System.out.println();
                    
            //     }
            // }
            
            for(int i=0;i<n;i++){
                for(int itr=0;itr+i<n;itr++){
                    for(int j=0;j<=itr;j++){
                        System.out.print(arr[j+i]+"	");   
                    }
                    System.out.println();
                }
                
                
            }
        
            
    }

}
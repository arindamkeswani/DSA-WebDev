// 1. You are given a number n, representing the number of rows and columns of a square matrix.
// 2. You are given n * n numbers, representing elements of 2d array a. 
// Note - Each row and column is sorted in increasing order.
// 3. You are given a number x.
// 4. You are required to find x in the matrix and print it's location int (row, col) format as discussed in output format below.
// 5. In case element is not found, print "Not Found".

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner x=new Scanner(System.in);
        int n= x.nextInt();
        
        int[][] arr=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=x.nextInt();
            }
        }
        
        
        int d=x.nextInt();
        
        int r=-1;int c=-1; //to store answer
        
      
        int i=0;int j=n-1;
        
        while(i<n && j>=0){
            if(arr[i][j]>d){
                    j--;
                }
            else if(arr[i][j]<d){
                i++;
            }
            else{
                r=i;
                c=j;
                break;
            }
        }
       
        
        if(r!=-1 && c!=-1){
            System.out.println(r);
            System.out.println(c);
        }
        else{
            System.out.println("Not Found");
        }
        
        // if(r==-1){
        //     System.out.println("Not found");
        // }
        // else{
            
        //     for(int j=0;j<n;j++){
        //         if(arr[r][j]==d){
        //             c=j;
        //             break;
        //         }
        //     }
            
        //     System.out.println(r);
        //     System.out.println(c);
        // }
        
        
        
        

        
    }

}
// 1. You are given a number n, representing the number of rows.
// 2. You are given a number m, representing the number of columns.
// 3. You are given n*m numbers (1's and 0's), representing elements of 2d array a.
// 4. Consider this array a maze and a player enters from top-left corner in east direction.
// 5. The player moves in the same direction as long as he meets '0'. On seeing a 1, he takes a 90 deg right turn.
// 6. You are required to print the indices in (row, col) format of the point from where you exit the matrix.

import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        int m = x.nextInt();

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) { //column
            for (int j = 0; j < m; j++) { //row
                arr[i][j] = x.nextInt();
            }
        }
        
        
        int d=0;//=east //1=south,2=west,3=north
        //direction control
        
        int i=0;
        int j=0;
        while(i>=0 && i<n && j>=0 && j<m){ //while point is still witin the matrix boundaries
            
            d=(d + arr[i][j])%4;
            
                if(d==0){
                    j++;
                }
                else if(d==1){
                    i++;
                }
                else if(d==2){
                    j--;
                }
                else{
                    i--;
                }
            }
        //
        
        // east(n,m,arr);
        
        if(i<0){
            System.out.println((i+1)+" "+j);
        }
        else if(i==n){
            System.out.println((i-1)+" "+j);
        }
        else if(j<0){
            System.out.println(i+" "+(j+1));
        }
        else{
            System.out.println((i)+" "+(j-1));
        }
        
            
    }
        
        // public static void east(int n,int m,int[][] arr){
        //     System.out.println((i)+""+(j));
        //     while(i>=0 && i<n && j>=0 && j<m){
        //         if(arr[i][j]==1){
        //             south(n,m,arr);
        //             break;
        //         }
        //         else{
        //             j++;
        //         }
        //     }
            
        //     // System.out.println(i+""+j);
                
        // }
        
        // public static void south(int n,int m,int[][] arr){
        
        //     while(i>=0 && i<n && j>=0 && j<m){
        //         if(arr[i][j]==1){
        //             west(n,m,arr);
        //             break;
        //         }
        //         else{
        //             i++;
        //         }
        //     }
            
        //     // System.out.println(i+""+j);
                
        // }
        
        // public static void west(int n,int m,int[][] arr){
        
        //     while(i>=0 && i<n && j>=0 && j<m){
        //         if(arr[i][j]==1){
        //             north(n,m,arr);
        //             break;
        //         }
        //         else{
        //             j--;
        //         }
        //     }
            
        //     // System.out.println(i+""+j);
                
        // }
        
        // public static void north(int n,int m,int[][] arr){
        
        //     while(i>=0 && i<n && j>=0 && j<m){
        //         if(arr[i][j]==1){
        //             east(n,m,arr);
        //             break;
        //         }
        //         else{
        //             i--;
        //         }
        //     }

        // }
        
        
    

}
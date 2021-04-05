// 1. You are given a number n, representing the number of rows.
// 2. You are given a number m, representing the number of columns.
// 3. You are given n*m numbers, representing elements of 2d array a.
// 4. You are required to traverse and print the contents of the 2d array in form of a spiral.
// Note - Please check the sample output for details.

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
        
        int minr=0;
        int minc=0;
        int maxr=n-1;
        int maxc=m-1;
        
        int c=0;
        
        while(c!=(n*m)){
            //left wall
            for(int i=minr;i<=maxr && (c!=(n*m));i++){
                System.out.println(arr[i][minc]);
                c++;
            }
            minc++;
            
            //down row to right direction
            for(int i=minc;i<=maxc && (c!=(n*m));i++){
                System.out.println(arr[maxr][i]);
                c++;
            }
            maxr--;
            
            //right wall to up
            for(int i=maxr;i>=minr && (c!=(n*m));i--){
                System.out.println(arr[i][maxc]);
                c++;
            }
            maxc--;
            
            //up wall to left 
            for(int i=maxc;i>=minc && (c!=(n*m));i--){
                System.out.println(arr[minr][i]);
                c++;
            }
            minr++;
            //update values
            
            
        }
        
        // for(int i=minc;i<=maxc;i++){
        //     System.out.println(arr[maxr][i]);
        // }
        
    }

}
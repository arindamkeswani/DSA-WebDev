// 1. You are given a number n, representing the number of rows and columns of a square   matrix.
// 2. You are given n * n numbers, representing elements of 2d array a.
// 3. You are required to diagonally traverse the matrix and print the contents.
// For details check image.

// ![image](https://s3.amazonaws.com/hr-assets/0/1585249079-9dd064c0d4-traversal.png)

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner x=new Scanner(System.in);
        int n=x.nextInt();
        
        int[][] arr = new int[n][n];
        
        //input
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = x.nextInt();
            }
        }
        
        int r = n - 1;
        int c = 0;
        
        boolean flag = true;
        System.out.println(arr[r][c]);
        c+=1;
        while (flag) {

            // upward slope
            while (r > 0 && c > 0) {
                System.out.println(arr[r][c]);
                r--;
                c--;
            }
            System.out.println(arr[r][c]); //edge element

            if (r == 0) {
                c++;
            } else {
                r--;
            }

            // downward slope
            while (r < n - 1 && c < n - 1) {
                System.out.println(arr[r][c]);
                r++;
                c++;
            }

            System.out.println(arr[r][c]); //edge element

            if (r == 0 && c == n - 1) //last element reached (top right corner)
                break;
            if (c == n - 1) { 
                r--;
            } else {
                c++;
            }
        }
        
    }
}
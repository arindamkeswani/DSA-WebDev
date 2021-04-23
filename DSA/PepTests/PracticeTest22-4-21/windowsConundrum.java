// 1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing the elements of array a.
// 3. You are given a number k, representing the size of window.
// 4. You are required to find and print the maximum element in every window of size k.

// e.g.
// for the array [2 9 3 8 1 7 12 6 14 4 32 0 7 19 8 12 6] and k = 4, the answer is [9 9 8 12 12 14 14 32 32 32 32 19 19 19]

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner x=new Scanner(System.in);
        int n=x.nextInt();
        int arr[]= new int[n];
        for(int i=0;i<n;i++){
            arr[i] = x.nextInt();
        }
        int k=x.nextInt();
        
        Queue<Integer> q= new ArrayDeque<>();
        
        for(int i=0;i<=n-k;i++){
            int max=Integer.MIN_VALUE;
            
            for(int j=0;j<k;j++){
                q.add(arr[i+j]);
                if(arr[i+j]>max){
                    max=arr[i+j];
                }
            }
            System.out.println(max);
            q.remove();
            
        }
    }
}
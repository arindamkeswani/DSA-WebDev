/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing elements of array a.
3. You are required to print a bar chart representing value of arr a.
*/


import java.util.*;
import java.lang.*;
public class Main {

    public static void main(String[] args) {

        // write your code here.
        Scanner x = new Scanner(System.in);

        //LCM and GCD a number
        int n = x.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) { //input of array elements
            arr[i] = x.nextInt();
        }
        
        int max=-1; //calculate max of element
        // int ind=-1;
        for(int k=0;k<n;k++){
            if(arr[k]>=max){
                max=arr[k];
                // ind=k;
            }
        }
        // System.out.println(max);
        
        
        for (int i = 0; i < max; i++) {
            
            int m=-1; //calculate max of element
            int ind=-1;
            for(int k=0;k<n;k++){
                if(arr[k]>=m){
                    m=arr[k];
                    // ind=k;
                }
            }
            for (int j = 0; j < n; j++) {
            
                if (arr[j] == m ) {
                    System.out.print("*	");
                    arr[j] -= 1;
                } 
                else {
                    System.out.print("	");
                }
            }
            System.out.println();
        }
    }

    // public int max(arr){
    //     int max=-1; //calculate max of element
    //     int ind=-1;
    //     for(int k=0;k<n;k++){
    //         if(arr[k]>=max){
    //             max=arr[k];
    //             ind=k;
    //         }
    //     }
    //     return max;
    // }
    //

}
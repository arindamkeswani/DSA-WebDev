// mr. pepper has a very weird, fashion sense(as given below). 

// Suppose you are given n elements in an array, thus elements should follow a 
// fashion(discipline).

// ele1 < ele2 > ele3 < ele4 > ele5 ........ (upto nth element).

// your task is to re-arrange the "DISTINCT" elements of array in proper fashion in O(n) time.
// The converted array should be in form a < b > c < d > e < f.

// Example : 
// input {5, 4, 3, 2}
// output {4, 5, 2, 3}



import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner x= new Scanner(System.in);
        int n=x.nextInt();
        
        int a[]= new int[n];
        for(int i=0;i<n;i++){
            a[i] = x.nextInt();
        }
        
        for(int i=0;i<n-1;i++){
            if(i%2==0){//ascending sort
                if(a[i]>a[i+1]){
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                }
            }else{ //descending sort
                if(a[i]<a[i+1]){
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                }
            }
        }
        
        for(int i=0;i<n;i++){
            System.out.print(a[i] + " ");
        }
        
    }

}
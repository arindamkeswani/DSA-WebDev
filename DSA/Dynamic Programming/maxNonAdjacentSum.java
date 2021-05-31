// 1. You are given a number n, representing the count of elements.
// 2. You are given n numbers, representing n elements.
// 3. You are required to find the maximum sum of a subsequence with no adjacent elements.
// Input Format
// A number n
// n1
// n2
// .. n number of elements
// Output Format
// A number representing the maximum sum of a subsequence with no adjacent elements.


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
    
    
    
    //make 2 rows, one for excluding particular element (in column), one for including it
    //make n columns
    
    //val of excluded row cell is max(prev column excl element, prev column incl element)
    //val of included row cell is (check if prev element is included, if yes then add prev excl value to current col value (so as to ignore the step where prev step is included)
    
    //Above process can be done woth 2 variables
    Scanner x=new Scanner(System.in);
    int n=x.nextInt();
    int a[]=new int[n];
    
    for(int i=0;i<n;i++){
        a[i] = x.nextInt();
    }
    
    //Logic
    int inc = 0, exc = 0;
    for(int i=0;i<n;i++){
        if(i==0){
            exc = 0;
            inc = a[0];
        }else{
            int newExcl = Math.max(exc, inc);
            int newIncl = exc+a[i];
            
            inc=newIncl;
            exc = newExcl;
        }
    }
    
    int res = Math.max(inc,exc);
    System.out.println(res);
    }
}
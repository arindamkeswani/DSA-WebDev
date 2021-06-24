// 1. You are given a number n and a number k in separate lines, representing the number of fences and number of colors.
// 2. You are required to calculate and print the number of ways in which the fences could be painted so that not more than two consecutive  fences have same colors.
// Input Format

// A number n
// A number k
// Constraints

// 1 <= n <= 10
// 1 <= k <= 10
// Output Format

// A number representing the number of ways in which the fences could be painted so that not more than two fences have same colors.
// Sample Input 0

// 2
// 7
// Sample Output 0

// 49

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner x=new Scanner(System.in);
        int n=x.nextInt();int k=x.nextInt();
        
        
        
        int endInSame=k; //starting at 2 colours
        int endInDiff=k*(k-1); //k colors* (k-1) remaining colours
        int total=endInSame + endInDiff; 
        for(int j=3; j<=n;j++){
            int newEndInSame = endInDiff; //as no combination from "end in same" can be used here due to repitition
            int newEndInDiff = total*(k-1); //all comb from previous total can be used but without repeating,except when it is same colour as last, so *(k-1) is done
            int newTotal = newEndInSame+newEndInDiff;
            
            endInSame = newEndInSame;
            endInDiff = newEndInDiff;
            total = newTotal;
        }
        
        System.out.println(total);
        
        
    }
}
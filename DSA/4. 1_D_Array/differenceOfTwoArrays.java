// 1. You are given a number n1, representing the size of array a1.
// 2. You are given n1 numbers, representing elements of array a1.
// 3. You are given a number n2, representing the size of array a2.
// 4. You are given n2 numbers, representing elements of array a2.
// 5. The two arrays represent digits of two numbers.
// 6. You are required to find the difference of two numbers represented by two arrays and print the arrays. a2 - a1

// Assumption - number represented by a2 is greater.

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner x = new Scanner(System.in);

        int n1 = x.nextInt();
        int[] arr1 = new int[n1];

        for (int i = 0; i < n1; i++) {
            arr1[i] = x.nextInt();
        }

        int n2 = x.nextInt();
        int[] arr2 = new int[n2];

        for (int i = 0; i < n2; i++) {
            arr2[i] = x.nextInt();
        }


        int diff = n1 < n2 ? n2 - n1 : n1 - n2;
        // max=n1<n2?n2:n1;

        int[] d = new int[n2];


        // if(max==n2){
        int carry = 0;
        for (int i = n1 - 1; i >= 0; i--) {
            if (arr2[i + diff] - arr1[i] +carry < 0) {

                d[i + diff] = arr2[i + diff] + 10 - arr1[i] + carry;
                carry = -1;
            } else {
                d[i + diff] = arr2[i + diff] - arr1[i] + carry;
                carry = 0;
            }
        }

        // int c=0;
        
        for(int i=diff-1;i>=0;i--){
            if (arr2[i] +carry < 0) {

                d[i] = arr2[i] + 10  + carry;
                carry = -1;
            } else {
                d[i] = arr2[i] + carry;
                carry = 0;
            }
        }
        
        int k = -1;
        do {
            k++;
        } while (d[k] == 0);

        if(k>=0){
            for (int i = k; i < d.length; i++) {
            System.out.println(d[i]);
            }
        }
        else{
            for (int i = 0; i < d.length; i++) {
            System.out.println(d[i]);
            }
        }
        

    }

}
// 1. You are given a number n1, representing the size of array a1.
// 2. You are given n1 numbers, representing elements of array a1.
// 3. You are given a number n2, representing the size of array a2.
// 4. You are given n2 numbers, representing elements of array a2.
// 5. The two arrays represent digits of two numbers.
// 6. You are required to add the numbers represented by two arrays and print the
// arrays.


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


        int low = n1 < n2 ? n1 : n2;
        int high = n1 > n2 ? n1 : n2;

        int diff = n1 < n2 ? n2 - n1 : n1 - n2;
        // System.out.println("Diff:"+diff+" "+high+" "+low);
        int[] arrsum = new int[high];

        int carry = 0;
        for (int k = low-1; k >=0; k--) {
            if (low == n1) {
                int d=carry + arr1[k] + arr2[k+diff];
                int val=d%10;
                arrsum[--high]=val;
                // high--;
                carry=d/10;
                
            }
            else{
                int d=carry + arr2[k] + arr1[k+diff];
                int val=d%10;
                arrsum[--high]=val;
                // high--;
                carry=d/10;
            }
        }
        for(int i=0;i<arrsum.length;i++){
            // System.out.print(arrsum[i]);
        }

        for(int i=diff-1;i>=0;i--){
            if (low == n1) {
                int d=arr2[i] + carry;
                int val=d%10;
                arrsum[--high]=val;
                // high--;
                carry=d/10;
            }
            else{
                int d=arr1[i] + carry;
                int val=d%10;
                arrsum[--high]=val;
                // high--;
                carry=d/10;
            }
        }
        
        if (carry!=0){
            System.out.println(carry);
        }
        
        for(int i=0;i<arrsum.length;i++){
            System.out.println(arrsum[i]);
        }

    }

}
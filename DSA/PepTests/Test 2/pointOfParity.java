// Mr. Pepper is facing a problem in understanding some information.
// He will be able to able to understand the information, if he is able
// to find "point of parity".
// Your task is to help him find such point. 
// (if "point of parity" exists print such point, otherwise print "-1")

// "point of parity" is defined as a place (index),which acts as a neutral-point.

// Example : 
// arr[] = {-10,-5,20,3,10,-5}
// point of parity = 3
// as ,arr[0] + arr[1] + arr[2] = arr[4] + arr[5].

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = scn.nextInt();
        }

        // code here
        
        int ans=-1;
        for(int i=0;i<arr.length;i++){
            int s1=0;
            int s2=0;
            
            for(int j=0;j<i;j++){
                s1+=arr[j];
            }
            
            for(int j=arr.length-1;j>i;j--){
                s2+=arr[j];
            }
            
            if(s2==s1){
                ans=i;
                break;
            }
        }
        
        System.out.println(ans);
    }
}
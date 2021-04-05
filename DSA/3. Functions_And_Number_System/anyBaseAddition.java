// 1. You are given a base b.
// 2. You are given two numbers n1 and n2 of base b.
// 3. You are required to add the two numbes and print their value in base b.

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getSum(b, n1, n2);
        System.out.println(d);
    }

    // public static int decimaltobase(int n, int b) {
    //     int result = 0;
    //     int power = 1;

    //     // int s;
    //     while (n != 0) {
    //         int a = n % b;
    //         result = result + power * a;
    //         power *= 10;
    //         n /= b;

    //     }
    //     return result;
    // }

    // public static int basetodecimal(int n, int b) {
    //     int power = 1;
    //     int res = 0;

    //     while (n != 0) {
    //         int a = n % 10;
    //         res = res + power * a;
    //         power *= b;
    //         n /= 10;
    //     }

    //     return res;

    // }


    public static int getSum(int sb, int n1, int n2) {
        // write ur code here
        // }
        // public int baseAdd(int n1,int b1,int int n2,int b2){
        //base conversion
        // int a = basetodecimal(n1, b);
        // int d = basetodecimal(n2, b);
        // int c = a + d;

        // int res = decimaltobase(c, b);
        int res=0;
        int pow=1;
        int carry=0;
        
        while(n1!=0 || n2!=0 || carry!=0){
            int y=n1%10;
            int z=n2%10;
            
            n1/=10;
            n2/=10;
            
            int sum=carry+y+z;
            
            
            
            
            carry=(sum)/sb;
            
            int val=sum%sb;
            
            res= res + pow*(val);
            pow*=10;
            
            
            // System.out.println(res);
        }

        return res;
    }
}
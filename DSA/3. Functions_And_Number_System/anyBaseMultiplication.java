// 1. You are given a base b.
// 2. You are given two numbers n1 and n2 of base b.
// 3. You are required to multiply n1 and n2 and print the value.

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();

        int d = getProduct(b, n1, n2);
        System.out.println(d);
    }



    public static int getSum(int sb, int n1, int n2) {

        int res = 0;
        int pow = 1;
        int carry = 0;

        while (n1 != 0 || n2 != 0 || carry != 0) {
            int y = n1 % 10;
            int z = n2 % 10;

            n1 /= 10;
            n2 /= 10;

            int sum = carry + y + z;




            carry = (sum) / sb;

            int val = sum % sb;

            res = res + pow * (val);
            pow *= 10;
        }

        return res;
    }

    
    public static int singleMult(int b,int d,int n2){
        // int res=0;
        int carry=0;
        int pow=1;
        int prod=0;
        while(n2!=0 || carry!=0){
            int a=n2%10;
            n2/=10;
            
            int val=(d*a + carry)%b;
            carry=(d*a + carry)/b;
            
            prod= prod + pow*(val);
            
            pow*=10;
            
        }
        
        return prod;
        
    }
    
    public static int getProduct(int b, int n1, int n2) {
        // write your code here


        int res = 0;
        int pow = 1;
        int sum=0;
        while (n1 != 0) {
            int d=n1%10;
            int part=singleMult(b,d,n2); //partial product of step
            int tempSum=pow*part;
            sum=getSum(b, tempSum, sum);
            pow*=10;
            
            n1/=10;
        }
        
        return sum;
    }
}
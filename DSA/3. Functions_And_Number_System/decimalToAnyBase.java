// 1. You are given a decimal number n.
// 2. You are given a base b.
// 3. You are required to convert the number n into its corresponding value in base b.

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int dn = getValueInBase(n, b);
        System.out.println(dn);
    }

    public static int getValueInBase(int n, int b) {
        // write code here
    
        int result=0;
        int power=1;
        
        // int s;
        while (n!=0){
            int a=n%b;
            result= result+ power*a;
            power*=10;
            n/=b;
            
        }
        return result;
    }
}
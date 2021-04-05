// 1. You are given a number n.
// 2. You are given a base b1. n is a number on base b.
// 3. You are given another base b2.
// 4. You are required to convert the number n of base b1 to a number in base b2.

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sourceBase = scn.nextInt();
        int destBase = scn.nextInt();
        
        System.out.println(basetobase(n,sourceBase,destBase));
        
    }
    
    public static int decimaltobase(int n, int b) {
        int result = 0;
        int power = 1;

        // int s;
        while (n != 0) {
            int a = n % b;
            result = result + power * a;
            power *= 10;
            n /= b;

        }
        return result;
    }

    // public static

    public static int basetodecimal(int n, int b) {
        int power = 1;
        int res = 0;

        while (n != 0) {
            int a = n % 10;
            res = res + power * a;
            power *= b;
            n /= 10;
        }

        return res;

    }

    public static int basetobase(int n, int b, int b2) {
        int a = basetodecimal(n, b);
        int res = decimaltobase(a, b2);
        return res;
    }
}
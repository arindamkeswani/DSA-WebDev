// 1. You are given a string that contains only lowercase and uppercase alphabets. 
// 2. You have to form a string that contains the difference of ASCII values of every two consecutive characters between those characters.
//    For "abecd", the answer should be "a1b3e-2c1d", as 
//    'b'-'a' = 1
//    'e'-'b' = 3
//    'c'-'e' = -2
//    'd'-'c' = 1

import java.io.*;
import java.util.*;

public class Main {

    public static String solution(String str) {
        // write your code here
        StringBuilder sb=new StringBuilder(str);
        int n = str.length();
        StringBuilder d = new StringBuilder("");
        for (int i = 0; i < n - 1; i++) {
            char c = sb.charAt(i);
            int c1 = (int) sb.charAt(i); //store ASCII value of ith and i+1th character
            int c2 = (int) sb.charAt(i + 1);
            String diff = String.valueOf(c2 - c1); //calculate difference and convert it to a string
            // d+=str.charAt(i);
            // d += c + diff + ""; //add difference character between the consequtive characters
            d.append(c);
            d.append(diff);
            // d.append(" ");
        }
        d.append(sb.charAt(n - 1));
        return String.valueOf(d);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }

}
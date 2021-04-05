// 1. You are given a string that contains only lowercase and uppercase alphabets. 
// 2. You have to toggle the case of every character of the given string.

import java.io.*;
import java.util.*;

public class Main {

    public static String toggleCase(String str) {
        //write your code here
        int n = str.length();
        String d = "";
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c) == true) {
                d = d + Character.toLowerCase(c);
            } else {
                d = d + Character.toUpperCase(c);
            }
        }

        return d;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(toggleCase(str));
    }

}


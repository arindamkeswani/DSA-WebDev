// 1. You are given a string. 
// 2. You have to compress the given string in the following two ways - 
//    First compression -> The string should be compressed such that consecutive duplicates of characters are replaced with a single character.
//    For "aaabbccdee", the compressed string will be "abcde".
//    Second compression -> The string should be compressed such that consecutive duplicates of characters are replaced with the character and followed by the number of consecutive duplicates.
//    For "aaabbccdee", the compressed string will be "a3b2c2de2".

import java.io.*;
import java.util.*;

public class Main {

    public static String compression1(String str) {
        // write your code here
        int n=str.length();
        String d="";
        
        for(int i=0;i<n;i++){
            int p=0;
            d=d+str.charAt(i);
            
            for(int j=i+1;j<n;j++){
                char c1=str.charAt(i);
                char c2=str.charAt(j);
                if(String.valueOf(c1).equals(String.valueOf(c2)) == true){
                    p++;
                }
                else{
                    break;
                }
            }
            i=i+p;
        }

        return d;
    }

    public static String compression2(String str) {
        // write your code here
        
        int n=str.length();
        String d="";
        
        for(int i=0;i<n;i++){
            int p=0;
            d=d+str.charAt(i);
            
            for(int j=i+1;j<n;j++){
                char c1=str.charAt(i);
                char c2=str.charAt(j);
                if(String.valueOf(c1).equals(String.valueOf(c2)) == true){
                    p++;
                }
                else{
                    break;
                }
                
            }
            i=i+p;
            if(p>=1)
                d+=String.valueOf(p+1);
        }

        return d;

        
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(compression1(str));
        System.out.println(compression2(str));
    }

}
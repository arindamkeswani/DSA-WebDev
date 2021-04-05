// 1. You are given a string. 
// 2. You have to print all palindromic substrings of the given string.


import java.io.*;
import java.util.*;

public class Main {

    public static void solution(String str) {
        //write your code here
        int n=str.length();
        // for(int i=0;i<n;i++){
            // String s=str.substring(i);
            // System.out.println(i);
           for(int j=0;j<n;j++) {
               String s=str.substring(j); //start from full string, will reduce from left side to right
               
               for(int k=0;k<s.length();k++){
                   String test=s.substring(0,k+1);   //test all substrings inside initial substrings from smallest and full string
                   
                   //for palindrome
                   String d="";
                   for(int i=0;i<test.length();i++){
                       d= test.charAt(i)+d;
                   }
                //   System.out.println(d+""+test);
                   if(d.equals(test)){
                       System.out.println(test);
                   }
               }
               
           }
        // }

    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        solution(str);
    }

}
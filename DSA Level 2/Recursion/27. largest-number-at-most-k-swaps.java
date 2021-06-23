// 1. You are given a string which represents digits of a number.
// 2. You have to create the maximum number by performing at-most k swap operations on its digits.

// Note -> Check out the question video and write the recursive code as it is intended without 
//                changing signature. The judge can't force you but intends you to teach a concept.
// Input Format
// A string S and a number K
// Output Format
// A number

/*
Sample Input
1234567
4
Sample Output
7654321
*/


import java.io.*;
import java.util.*;

public class Main {

	static String max;
	public static void findMaximum(String str, int k) {
		//write your code here
		//swap with numbers ahead of curr number only if resultant no. is greater
		//keep doing so for k-levels
		//print max of all calculated combinations
		
// 		max=str;
        if(Integer.parseInt(max)<Integer.parseInt(str)){
		    max=str;
		}
		if(k==0){
		    return;
		}
		
		for(int i=0;i<str.length();i++){
		    for(int j=i+1;j<str.length();j++){
		        if(str.charAt(j)>str.charAt(i)){//swap with numbers ahead of curr number only if resultant no. is greater
		            String swpdString= swap(str,i,j);
		            findMaximum(swpdString, k-1);//keep doing so for k-levels
		        }
		    }
		}
	}
	
	public static String swap(String str, int i, int j){
	   // return str.substring(0,i)+str.charAt(j)+str.substring(i+2,i)
	   StringBuilder sb=new StringBuilder(str);
	   char ich= sb.charAt(i);
	   char jch= sb.charAt(j);
	   sb.setCharAt(i,jch);
	   sb.setCharAt(j,ich);
	   return sb.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int k = scn.nextInt();
		 max = str;
		findMaximum(str, k);
		System.out.println(max);
	}

}
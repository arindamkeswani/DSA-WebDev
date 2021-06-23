// 1. You are given a number.
// 2. You have to print all the numbers from 1 to n in lexicographical order.

// Note -> Check out the question video and write the recursive code as it is intended without 
//                changing signature. The judge can't force you but intends you to teach a concept.
// Input Format
// A number
// Output Format
// Check the sample output and question video

// 14
// Sample Output
// 1
// 10
// 11
// 12
// 13
// 14
// 2
// 3
// 4
// 5
// 6
// 7
// 8
// 9

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		//write your code here
		for(int i=1;i<=9;i++){ //digits needs to be printed started from 1
		    lexi(i,n);    
		}
		
	}
	
	public static void lexi(int a, int n){
	   
	    if(a>n){
	        return;
	    }
	    
	    System.out.println(a);
	    
	    for(int digit=0;digit<=9;digit++){ 
	        lexi((a*10)+digit, n); //send next number in lexi order for eval
	    }
	    
	}
	
}
// 1. You are given a string of length n.
// 2. You have to partition the given string in such a way that every partition is a palindrome.

// Note -> Check out the question video and write the recursive code as it is intended without 
//                changing signature. The judge can't force you but intends you to teach a concept.
// Input Format
// A String of length n
// Output Format
// Check the sample ouput and question video.

/*
Sample Input
pep
Sample Output
(p) (e) (p) 
(pep) 
*/

import java.io.*;
import java.util.*;

public class Main {

	public static void solution(String str, String asf) {
		//write you code here
		if(str.length()==0){ // all characters in string parsed
		    System.out.println(asf);
		    return;
		}
		
		for(int i=0;i<str.length();i++){ //go through each character of the string
		    String prefix=str.substring(0,i+1); //get val to be tested
		    String ros=str.substring(i+1); //get value to be passed on for testing in next call
		    if(isPalindrome(prefix)){ //is val is palindrome, add it to answer and check next val, otherwise check for next value
		        solution(ros,asf+"("+prefix+") ");
		    }
		}
	}
	
	public static boolean isPalindrome(String s){ //check palindrome
	    boolean flag=true;
	    int p1=0;
	    int p2=s.length()-1;
	    while(p1<p2){
	        if(s.charAt(p1)!=s.charAt(p2)){
	            flag=false;
	        }
	        p1++;
	        p2--;
	    }
	    return flag;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		solution(str, "");
	}

}
// 1. You are given a string, which represents an expression having only opening and closing parenthesis.
// 2. You have to remove minimum number of parenthesis to make the given expression valid.
// 3. If there are multiple answers, you have to print all of them.

// Note -> Check out the question video and write the recursive code as it is intended without changing signature. The judge can't 
//                force you but intends you to teach a concept.
// Input Format
// A string containing only opening and closing parenthesis
// Output Format
// Print all the Valid expressions.
// Check the sample ouput and question video.

/*
Sample Input
()())()
Sample Output
(())()
()()()
*/


import java.io.*;
import java.util.*;

public class Main {

	public static void solution(String exp,int minRemoval, HashSet<String> ans) {
		//write your code here
		if(minRemoval==0){
		    if(getMin(exp)==0 && ans.contains(exp)==false){
		        //removal done + exp is valid + not already printed
		        System.out.println(exp);
		        ans.add(exp); //add to answer list to avoid repitition
		    }
		    return;
		}
		
		StringBuilder sb= new StringBuilder(exp);
		for(int i=0;i<exp.length();i++){
		    sb.deleteCharAt(i); //remove char from string
		    String ros= sb.toString(); 
		    solution(ros, minRemoval-1,ans); //test remaining string for validity and completeness
		    sb.insert(i, exp.charAt(i)); //backtrack
		}
	}

	public static int getMin(String str){ //to get min no. of deletions
		//write your code here
		Stack<Character> st=new Stack<>();
		
		for(int i=0;i<str.length();i++){
		    char ch= str.charAt(i);
		    
		    if(ch=='('){
		        st.push(ch);
		    }else if(ch==')'){
		        if(st.size()==0){
		            st.push(ch);
		        }else if(st.peek()=='('){
		            st.pop();
		        }else if(st.peek()==')'){
		            st.push(ch);
		        }
		    }
		}
		return st.size();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str, getMin(str),new HashSet<>());
	}
		
}
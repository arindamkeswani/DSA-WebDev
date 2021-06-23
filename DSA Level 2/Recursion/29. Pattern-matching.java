// 1. You are given a string and a pattern. 
// 2. You've to check if the string is of the same structure as pattern without using any regular 
//      expressions.

// Note -> Check out the question video and write the recursive code as it is intended without 
//                changing signature. The judge can't force you but intends you to teach a concept.
// Input Format
// A String str
// A pattern ptr
// Output Format
// Check the sample ouput and question video.

// Sample Input
// graphtreesgraph
// pep
// Sample Output
// p -> graph, e -> trees, . 

import java.io.*;
import java.util.*;

public class Main {

	public static void solution(String str, String pattern, HashMap<Character,String> map, String op){
		//write your code here
		
		if(pattern.length()==0){
		    if(str.length()==0){
		        HashSet<Character> set=new HashSet<>();
		        for(int i=0;i<op.length();i++){
		            char ch=op.charAt(i);
		            if(set.contains(ch)==false){
		                System.out.print(ch+" -> "+map.get(ch)+", ");
		                set.add(ch); //to avoid repitition in printing
		            }
		          //  System.out.print(ch+"->"+map.get(ch)+",");
		        }
		        System.out.println(".");
		    }
		    return;
		}
		char patCh= pattern.charAt(0); //pattern character to be tested
		String rop = pattern.substring(1); //rest of pattern
		
		if(map.containsKey(patCh) == true){
		    //already mapped
		    String prevMapping = map.get(patCh);
		    if(str.length()<prevMapping.length()){
		        //ch prev mapping is not valid according to string
		        return;
		    }
		    String nextMapping=str.substring(0, prevMapping.length()); //attempt a valid mapping of same size as prev mapping
		    
		    if(prevMapping.equals(nextMapping)){ //if mapping turns out to be valid
		        //ch prev mapping is valid according to string till now
		        String ros=str.substring(prevMapping.length());
		        solution(ros, rop, map, op);
		    }else{
		        return;
		    }
		    
		}else{
		    //first time mapping
		    for(int i=0;i<str.length();i++){
		        String fp=str.substring(0,i+1); //first part->this gets mapped
		        String sp=str.substring(i+1); //second part->this gets sent for further evaluation
		        
		        map.put(patCh, fp); //map curr substring    
		        solution(sp,rop,map,op); //test more. If wrong ans, then backtrack
		        map.remove(patCh); //backtracking
		    }
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		String pattern = scn.next();
		HashMap<Character,String> map = new HashMap<>();
		solution(str,pattern,map,pattern);
	}
}
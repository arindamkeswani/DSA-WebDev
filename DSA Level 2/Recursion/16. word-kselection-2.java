// 1. You are given a word (may have one character repeat more than once).
// 2. You are given an integer k.
// 2. You are required to generate and print all ways you can select k distinct characters out of the 
//      word.
 
// Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
//                force you but the intention is to teach a concept. Play in spirit of the question.

// Input Format
// Input is managed for you
// Output Format
// Check the sample ouput and question video. 


import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    String st = scn.nextLine();
    int k = scn.nextInt();
    
    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for(char ch : st.toCharArray()){
        if(unique.contains(ch)== false){
            unique.add(ch);
            ustr+=ch;
        }
    }
    
    combination(-1,ustr,0,k,"");
  }
  
    public static void combination(int lb,String ustr,int ssf, int ts, String asf ){
        //box determines which corresponding unique char is selected
        if(ssf==ts){
            System.out.println(asf);
            return;
        }
        for(int i=lb+1;i<ustr.length();i++){
            combination(i,ustr,ssf+1,ts,asf+ustr.charAt(i));
        }
    }
    
}
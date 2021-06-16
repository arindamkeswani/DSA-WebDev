// 1. You are given a word (may have one character repeat more than once).
// 2. You are given an integer k.
// 3. You are required to generate and print all k length words (of distinct chars) by using chars of the 
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

 
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }
    generateWords(1, k,new HashSet<>(), "", ustr);
   
  }
    
    public static void generateWords(int cs, int ts, HashSet<Character> usedChar,String asf, String ustr){
       if(cs>ts){
           System.out.println(asf);
           return;
       }
       
       for(int idx=0;idx<ustr.length();idx++){
           char ch=ustr.charAt(idx);
           if(usedChar.contains(ch)==false){
               usedChar.add(ch);
               generateWords(cs+1, ts, usedChar, asf+ch, ustr);
               usedChar.remove(ch);
           }
       }
   }
};
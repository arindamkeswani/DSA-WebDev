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
    generateWords(k,0,new Character[k], 0,ustr);
    
  }
  
  public static void generateWords(int totalSpots, int spotsFSF, Character spot[], int idx, String ustr){
      //Box chooses whether character will come in it or not, if yes then which. Then character chooses which box will it go in.
      //this is basically permutation
      if(idx==ustr.length()){
          if(spotsFSF==totalSpots){
              for(Character ch:spot){
                  System.out.print(ch);
              }
              System.out.println();
          }
          return;
      }
      
      char ch=ustr.charAt(idx);
      for(int i=0;i<spot.length;i++){ //calc permutations
          if(spot[i]==null){
              spot[i]=ch;
              generateWords(totalSpots,spotsFSF+1,spot,idx+1,ustr );
              spot[i]=null;
          }
      }
      
      generateWords(totalSpots,spotsFSF,spot,idx+1,ustr ); //in case no spot is filled
  }

}
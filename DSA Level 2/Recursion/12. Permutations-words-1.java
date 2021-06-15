// 1. You are given a word (may have one character repeat more than once).
// 2. You are required to generate and print all arrangements of these characters. 

// Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
//                force you but the intention is to teach a concept. Play in spirit of the question.
// Input Format
// Input is managed for you
// Output Format
// Check the sample ouput and question video. 

import java.io.*;
import java.util.*;

public class Main {

  public static void generateWords(int cs, int ts, HashMap<Character, Integer> fmap, String asf) {
    // write your code here
    //Perspective: Box chooses
    if(cs>ts){
        System.out.println(asf);
        return;
    }
    for(char ch : fmap.keySet()){ //traverse through all unique characters
        if(fmap.get(ch)>0){ //check if character still has quantity/duplicates left
            fmap.put(ch,fmap.get(ch)-1); //reduce freq of character as we are putting it in string
            generateWords(cs+1,ts,fmap,asf+ch); //evaluate next character (or same one depending on freq)
            fmap.put(ch,fmap.get(ch)+1); //restore val to test all permutations
        }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    HashMap<Character, Integer> fmap = new HashMap<>();
    for(char ch: str.toCharArray()){
      if(fmap.containsKey(ch)){
        fmap.put(ch, fmap.get(ch) + 1);
      } else {
        fmap.put(ch, 1);
      }
    }

    generateWords(1, str.length(), fmap, "");
  }

}
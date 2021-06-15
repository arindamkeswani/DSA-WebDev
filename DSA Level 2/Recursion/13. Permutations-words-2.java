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

  public static void generateWords(int cc, String str, Character[] spots, 
                                   HashMap<Character, Integer> lastOccurence) {
    // write your code here
    //Perspective: Object chooses
    //We use combination logic(keep track of last used box) in case of similar char, to avoid repitition
    //Then for new char, we use permutation logic, ie going from start to finish and occupy empty spots
    
    if(cc==str.length()){ //when permutation is complete, print it and return
        for(Character ch:spots){
            System.out.print(ch);
        }
        System.out.println();
        return;
    }
    
    char ch=str.charAt(cc); //get current character
    int lo = lastOccurence.get(ch); //if char has not been used, this will return -1
    
    for(int i=lo+1 ; i<spots.length;i++){ //taking lo+1 to avoid repitition
        if(spots[i]==null){ //is spot is not filled
            spots[i]=ch;
            lastOccurence.put(ch,i); //update last occurence of curr char
            generateWords(cc+1, str, spots,lastOccurence); //eval for next char
            lastOccurence.put(ch,lo); //restore prev last occurence of curr char
            spots[i]=null;
        }
    }
    
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();

    Character[] spots = new Character[str.length()];
    HashMap<Character, Integer> lastOccurence = new HashMap<>();
    for(char ch: str.toCharArray()){
      lastOccurence.put(ch, -1);
    }

    generateWords(0, str, spots, lastOccurence);
  }

}
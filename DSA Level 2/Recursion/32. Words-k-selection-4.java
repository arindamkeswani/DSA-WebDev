// 1. You are given a word (may have one character repeat more than once).
// 2. You are given an integer k.
// 3. You are required to generate and print all ways you can select k characters out of the word.

// Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't force you but the intention is to teach a concept. Play in spirit of the question.
// Input Format
// Input is managed for you
// Output Format
// Check the sample ouput and question video. 

/*
Sample Input
aabbbccdde
3
Sample Output
aab
aac
aad
aae
abb
abc
abd
abe
acc
acd
ace
add
ade
bbb
bbc
bbd
bbe
bcc
bcd
bce
bdd
bde
ccd
cce
cdd
cde
dde
*/



import java.io.*;
import java.util.*;

public class Main {

  

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashMap<Character, Integer> unique = new HashMap<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.containsKey(ch) == false) {
        unique.put(ch, 1);
        ustr += ch;
      } else {
        unique.put(ch, unique.get(ch) + 1);
      }
    }

    comb(ustr, unique, 0, k, "", 0);
  }
  
  
    public static void comb(String ustr, HashMap<Character, Integer> fmap, int currSpot, int totalSpots,String asf, int lastCharUsed){
        //Each level represents a spot (out of k spots)
        //Spot 1 can have either a,b,or c
        //if a selected, then spot 2 can have b or c and so on
        
        //Using lastCharUsed to avoid repititions
        if(currSpot==totalSpots){
            System.out.println(asf);
            return;
        }
       
        for(int i=lastCharUsed; i<ustr.length();i++){
            char ch=ustr.charAt(i);
            if(fmap.get(ch)>0){
                fmap.put(ch,fmap.get(ch)-1); //reduce freq as character is used
                comb(ustr, fmap, currSpot+1, totalSpots, asf+ch, i);
                fmap.put(ch,fmap.get(ch)+1); //backtrack and restore freq to test more combinations
            }
        }
    }
}
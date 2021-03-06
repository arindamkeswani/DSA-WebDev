// 1. You are give a number of boxes (nboxes) and number of non-identical items (ritems).
// 2. You are required to place the items in those boxes and print all such configurations possible.

// Items are numbered from 1 to ritems.
// Note 1 -> Number of boxes is greater than number of items, hence some of the boxes may remain 
//                    empty.
// Note 2 -> Check out the question video and write the recursive code as it is intended without 
//                    changing signature. The judge can't force you but intends you to teach a concept.
// Input Format
// Input is managed for you
// Output Format
// Check the sample ouput and question video. 0 means empty box.


import java.io.*;
import java.util.*;

public class Main {

  public static void permutations(int cb, int tb, int[] items, int ssf, int ts, String asf){
    // write your code here
    if(cb>tb){
        if(ssf==ts){
            System.out.println(asf);
        }
        return;
    }
    
    for(int i=0;i<items.length;i++){
        if(items[i]==0){ //item is unused
            items[i]=1; //mark as used
            permutations(cb+1, tb, items,ssf+1,ts,asf+(i+1));
            items[i]=0; //unmark
        }
    }
    permutations(cb+1, tb, items,ssf,ts,asf+"0"); //when nothing is selected
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(1, nboxes, new int[ritems], 0, ritems, "");
  }

}
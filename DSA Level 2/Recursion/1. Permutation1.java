// 1. You are give a number of boxes (nboxes) and number of non-identical items (ritems).
// 2. You are required to place the items in those boxes and print all such configurations possible.

// Items are numbered from 1 to ritems.
// Note 1 -> Number of boxes is greater than number of items, hence some of the boxes may remain empty.
// Note 2 -> Check out the question video and write the recursive code as it is intended without changing signature. The judge can't 
//                    force you but intends you to teach a concept.
// Input Format
// Input is managed for you
// Output Format
// Check the sample ouput and question video. 0 means empty box.


import java.io.*;
import java.util.*;

public class Main {

  public static void permutations(int[] boxes, int ci, int ti){
    // write your code here
    //Perspective=Permutation-1 : Object chooses which box it wants to go into. Then next object chooses from remaining places, and so on
//in case of identical items, permutation can be considered as combination
    if(ci>ti){ //if all items are evaluated, print permutation(ci=curent item, ti=total item, boxes=box array)
    for(int vl:boxes){
        System.out.print(vl);
    }
    System.out.println();
    return;
    }
    for(int box=0;box<boxes.length; box++){
        if(boxes[box]==0){//box is empty
            boxes[box] = ci; //mark box with current object
            permutations(boxes, ci+1,ti);  //fill with//evaluate next object
            boxes[box] = 0; //unvisit box, to check for all combinations
        }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(new int[nboxes], 1, ritems);
  }

}
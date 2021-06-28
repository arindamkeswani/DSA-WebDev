// 1. You are given an integer n, which represents n friends numbered from 1 to n.
// 2. Each one can remain single or can pair up with some other friend.
// 3. You have to print all the configurations in which friends can remain single or can be paired up.

// Note -> Check out the question video and write the recursive code as it is intended without 
//                changing signature. The judge can't force you but intends you to teach a concept.
// Input Format
// A number n
// Output Format
// Check the sample ouput and question video.

/*
Sample Input
3
Sample Output
1.(1) (2) (3) 
2.(1) (2,3) 
3.(1,2) (3) 
4.(1,3) (2) 
*/

import java.io.*;
import java.util.*;

public class Main {
  static int counter = 1;

  public static void solution(int i, int n, boolean[] used, String asf) {
    // write your code here
    
    if(i>n){ //finished all choices in the path
        System.out.println(counter+"."+asf); 
        counter++;
        return;
    }
    
    if(used[i]==true){ //is already paired up, move to next element
        solution(i+1, n, used, asf); 
    }
    else{
        used[i]=true; //mark curr element as used (single or pair)
        solution(i+1, n, used, asf+"("+i+") ");//remaining single
        
        for(int j=i+1;j<n+1;j++){
            if(used[j]==false){ //if single, pair it up with curr element
                used[j]=true; //mark as visited because it is not paired
                solution(i+1, n, used, asf+"("+i+","+j+") "); //pairing up
                used[j]=false; //unpaur it to test more comb
            }
            
        }
        used[i]=false; //mark as unused
    }
    
    
  }

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    boolean[] used = new boolean[n + 1];
    solution(1, n, used, "");
  }
}

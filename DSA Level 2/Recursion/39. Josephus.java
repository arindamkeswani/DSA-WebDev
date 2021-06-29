// 1. You are given two numbers N and K.
// 2. N represents the total number of soldiers standing in a circle having position marked from 0 to N-1.
// 3. A cruel king wants to execute them but in a different way.
// 4. He starts executing soldiers from 0th position and proceeds around the circle in clockwise direction.
// 5. In each step, k-1 soldiers are skipped and the k-th soldier is executed.
// 6. The elimination proceeds around the circle (which is becoming smaller and smaller as the executed soldiers are removed), until only the last soldier remains, who is given freedom.
// 7. You have to find the position of that lucky soldier.

// Note -> Check out the question video and write the recursive code as it is intended without  changing signature. The judge can't force you but intends you to teach a concept.
// Input Format
// 2 numbers N and K
// Output Format
// Check the sample ouput and question video.

/*
Sample Input
4
2
Sample Output
0
*/
import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int n, int k){
    //write your code here
    //kill kth person
    //transform by putting 0 to k-1 values at the end and, and transforming new arr to 0 to n-1
    // continue till only 1 elem remains
    // then revert the transformation back to the very original value through all the recursion layers
    
    
    if(n==1){
        return 0;
    }
    int y=solution(n-1,k); //will give final survivor
    int x=(y+k)%n; //reverse transformation formula

    return x;
  }
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int k = scn.nextInt();
    System.out.println(solution(n,k));
  }
  

}
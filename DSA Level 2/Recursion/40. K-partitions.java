// 1. You are given two integers n and k, where n represents number of elements and k represents 
//      number of subsets.
// 2. You have to partition n elements in k subsets and print all such configurations.

// Note -> Check out the question video and write the recursive code as it is intended without 
//                changing signature. The judge can't force you but intends you to teach a concept.
// Input Format
// A number n
// A number k
// Output Format
// Check the sample ouput and question video.

/*
Sample Input
3
2
Sample Output
1. [1, 2] [3] 
2. [1, 3] [2] 
3. [1] [2, 3] 
*/

//no permutations + non-empty subsets
//either occupy an empty set or a non empty set

import java.io.*;
import java.util.*;

public class Main {
    static int counter=1;
	public static void solution(int i, int n, int k, int rssf, ArrayList<ArrayList<Integer>> ans) {
		//write your code here
		if(i>n){
		    if(rssf==k){
		        System.out.print(counter+". ");
		        for(ArrayList<Integer> set: ans){
		            System.out.print(set+" ");
		        }
		        System.out.println();
		        counter++;
		    }
		    return;
		}
		for(int idx=0;idx<k;idx++){
		    ArrayList<Integer> set= ans.get(idx);
		    if(set.size()!=0){ //when current set is not empty
		        set.add(i); //add element to it
		        solution(i+1, n, k, rssf, ans); //check for next element
		        set.remove(set.size()-1); //backtrack
		    }else{
		        set.add(i);  //when current set is empty
		        solution(i+1, n, k, rssf+1, ans); //check for next element and add 1 to no of non-empty sets
		        set.remove(set.size()-1); //backtrack
		        break; //to prevent permutations
		    }
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i  = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		solution(1, n, k, 0, ans);

	}

}

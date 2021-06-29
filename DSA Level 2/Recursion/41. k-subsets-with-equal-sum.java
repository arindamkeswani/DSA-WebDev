// 1. You are given an array of n distinct integers.
// 2. You have to divide these n integers into k non-empty subsets such that sum of integers of every 
//      subset is same.
// 3. If it is not possible to divide, then print "-1".

// Note -> Check out the question video and write the recursive code as it is intended without 
//                changing signature. The judge can't force you but intends you to teach a concept.
// Input Format
// A number n
// n distinct integers 
// A number k
// Output Format
// Check the sample ouput and question video.

/*
Sample Input
6
1
2
3
4
5
6
3
Sample Output
[1, 6] [2, 5] [3, 4] 
*/


import java.io.*;
import java.util.*;

public class Main {


	public static void solution(int[] arr, int vidx,int n , int k,int[] subsetSum,int ssssf, ArrayList<ArrayList<Integer>> ans) {
		//write your code here
		if(vidx==arr.length){ //all elements parsed
		    if(ssssf==k){//we have apprp no of partitions
		        boolean flag=true;
		        for(int i=0;i<subsetSum.length-1;i++){
		            if(subsetSum[i]!=subsetSum[i+1]){ //if all the sums are not equal, break and set flag to false
		                flag=false;
		                break;
		            }
		        }
		        if(flag){
		            for(ArrayList<Integer> parition: ans){
		                System.out.print(parition+" ");
		            }
		            System.out.println();
		        }
		    }
		    return;
		}
		
		for(int i=0;i<ans.size();i++){
		    if(ans.get(i).size()>0){ // either curr element goes in non-empty subset
		        ans.get(i).add(arr[vidx]);
		        subsetSum[i]+=arr[vidx]; //add value to curr partition's sum
		        solution(arr, vidx+1, n, k, subsetSum, ssssf, ans); //
		        subsetSum[i]-=arr[vidx]; //add value to curr partition's sum
		        ans.get(i).remove(ans.get(i).size()-1);//backtrack
		    }else{ //or it goes in empty subset (to start a new one)
		        ans.get(i).add(arr[vidx]);
		        subsetSum[i]+=arr[vidx]; //add value to curr partition's sum
		        solution(arr, vidx+1, n, k, subsetSum, ssssf+1, ans); //increase number of non-empty subsets as a new one is formed
		        subsetSum[i]-=arr[vidx]; //add value to curr partition's sum
		        ans.get(i).remove(ans.get(i).size()-1); //backtrack
		        break;
		    }
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		int sum = 0;
		for(int i =  0 ; i < arr.length; i++) {
			arr[i] = scn.nextInt();
			sum += arr[i];
		}
		int k = scn.nextInt();
		// if k is equal to 1, then whole array is your answer 
		if(k == 1) {
			System.out.print("[");
			for(int i = 0 ; i  < arr.length; i++) {
				System.out.print(arr[i] + ", ");
			}
			System.out.println("]");
			return;
		}
		//if there are more subsets than no. of elements in array or sum of all elements is not divisible by k
		if(k > n || sum % k != 0) {
			System.out.println("-1");
			return;
		}
		int[] subsetSum = new int[k];
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		solution(arr,0,n,k,subsetSum,0,ans);
	}
	
	

}
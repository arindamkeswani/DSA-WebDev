// 1. You are given an array(arr) of integers.
// 2. You have to sort the given array in increasing order using count sort.
// Input Format
// An Integer n 
// arr1
// arr2..
// n integers
// Output Format
// Check the sample ouput and question video.



import java.io.*;
import java.util.*;

public class Main {

  public static void countSort(int[] arr, int min, int max) {
   //write your code here
   //O(n) =>[4n + (nRange)]
    //Not commonly preferred when range of values is very high
    //Space complexity = O(Math.max(n,nRange))
    int numUnique=max-min+1;
    int freq[] = new int[numUnique];
    
    for(int val:arr){ //map elements with their frequencies
        freq[val-min]++;
    }
    
    for(int idx=1;idx<numUnique;idx++){ //cumulative frequencies
        freq[idx] += freq[idx-1];
    }
    
    int res[]=new int[arr.length]; //result array
    
    for(int idx=arr.length-1;idx>=0;idx--){
        int val = arr[idx]; //value of element from unsorted array
        int pos = val-min; //position mapped in freq array
        int place = freq[pos]; //place of current element in the resultant array acc to freq array
        res[place-1] = val; //place - 1 is index of current element in resultant array
        freq[pos]--; //update value of current elements in freq table
    }
    
    for(int i=0;i<arr.length;i++){
        arr[i] = res[i];
    }
   
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }
    countSort(arr,min,max);
    print(arr);
  }

}
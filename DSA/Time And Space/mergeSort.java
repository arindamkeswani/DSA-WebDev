// 1. You are given an array(arr) of integers.
// 2. You have to sort the given array in increasing order using the merge sort.
// Input Format
// An Integer n 
// arr1
// arr2..
// n integers
// Output Format
// Check the sample output and question video.


import java.io.*;
import java.util.*;

public class Main {
    //Recurrence relation O(n)=>T(n) = 2*T(n/2) + n
    //O(n log n)
  public static int[] mergeSort(int[] arr, int lo, int hi) {
    //write your code here
    //this is not in-place sorted as new array in created during merging
    if(lo==hi){ //O(1)
        return new int[]{arr[lo]}; //return array with the only element in it, which will be merged with another single element in order
    }
    
    int mid = (lo+hi)/2; //get mid point of (sub)array
    int lpart[] = mergeSort(arr,lo,mid); //get sorted array from left of mid (incl mid) -> O(n/2)
    int rpart[] = mergeSort(arr,mid+1,hi);//get sorted array from right of mid (incl mid) -> O(n/2)
    
    return mergeTwoSortedArrays(lpart,rpart); //merge the two sorted parts in order -> O(n)
  }

  //used for merging two sorted arrays
  public static int[] mergeTwoSortedArrays(int[] a, int[] b){
    System.out.println("Merging these two arrays ");
    System.out.print("left array -> ");
    print(a);
    System.out.print("right array -> ");
    print(b);
    int i = 0, j =0, k = 0;
    int[] ans = new int[a.length + b.length];
    while(i < a.length && j < b.length){
        if(a[i] <= b[j]){
          ans[k] = a[i];
          i++;
          k++;
        }else{
          ans[k] = b[j];
          j++;
          k++;
        }
    }

    while(i < a.length){
      ans[k] = a[i];
      k++;
      i++;
    }

    while(j < b.length){
      ans[k] = b[j];
      k++;
      j++;
    }
    
    return ans;
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int[] sa = mergeSort(arr,0,arr.length - 1);
    System.out.print("Sorted Array -> ");
    print(sa);
  }

}
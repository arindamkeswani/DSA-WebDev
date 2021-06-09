// 1. You are given an array(arr) of integers.
// 2. You have to sort the given array in increasing order using quick-sort.
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

  public static void quickSort(int[] arr, int lo, int hi) {
    //write your code here
    //set pivot to last element
    //perform partition (this will put pivot index in correct place, only when pivot is last elem)
    //make last elements of left and right subarrays the respective pivots and do this recursively
    //In-place sorting algotrithm
    
    if(lo>hi){
        return;
    }
    int pivot = arr[hi]; //set pivot value
    int pidx= partition(arr,pivot, lo,hi); //to calc pivot index
    
    quickSort(arr,lo,pidx-1); //apply quickSort on subarray left of pivot
    quickSort(arr,pidx+1,hi); //apply quickSort on subarray right of pivot

    
  }

  public static int partition(int[] arr, int pivot, int lo, int hi) {
    System.out.println("pivot -> " + pivot);
    int i = lo, j = lo;
    while (i <= hi) {
      if (arr[i] <= pivot) {
        swap(arr, i, j);
        i++;
        j++;
      } else {
        i++;
      }
    }
    System.out.println("pivot index -> " + (j - 1));
    return (j - 1);
  }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
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
    quickSort(arr, 0, arr.length - 1);
    print(arr);
  }

}
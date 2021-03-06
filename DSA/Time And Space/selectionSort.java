
// 1. You are given an array(arr) of integers.
// 2. You have to sort the given array in increasing order using selection sort.
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

  public static void selectionSort(int[] arr) { //Total op= n(n-1) , Complexity =O(n^2)
    //write your code here
    
    
    for(int itr = 0;itr<arr.length-1;itr++){ //itr represents index value that will be sorted in this iteration
        int minIdx=itr; //min value index set as itr as base value
        for(int idx = itr+1;idx<arr.length;idx++){ //check all values to itr's right to see what is the lowest value
            if(isSmaller(arr,idx,minIdx)){ //check if current idx in less than minIdx
                minIdx=idx; //update minIdx
            }
        }
        swap(arr,itr,minIdx); //swap current idx with minIndex
    }
    
  }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  // return true if ith element is smaller than jth element
  public static boolean isSmaller(int[] arr, int i, int j) {
    System.out.println("Comparing " + arr[i] + " and " + arr[j]);
    if (arr[i] < arr[j]) {
      return true;
    } else {
      return false;
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
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    selectionSort(arr);
    print(arr);
  }

}
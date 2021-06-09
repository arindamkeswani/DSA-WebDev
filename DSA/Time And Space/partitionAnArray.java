// 1. You are given an array(arr) of integers and a pivot.
// 2. You have to re-arrange the given array in such a way that all elements smaller or equal to pivot lie on the left side of pivot and all elements greater than pivot lie on its right side.
// 3. You have to achieve this in linear time.

// Note -> For more information, watch question video.
// Input Format
// An Integer n 
// arr1
// arr2..
// n integers
// An integer pivot
// Output Format
// Check the sample output and question video.




import java.io.*;
import java.util.*;

public class Main {

  public static void partition(int[] arr, int pivot){
    //write your code here
    int i=0;int j=0;
    while(i<arr.length && j<arr.length){ //can we valid with just the first condition
        if(arr[i]<=pivot){ //when we encounter a "smaller value", we send it towards the start of the array, where j index is. We increment both pointers
            swap(arr,i,j);
            i++;j++;
        }else{ // when value is larger than pivot, we let it stay where it is (possible swapped by a smaller value in the future, when this value becomes j index)
           i++; 
        }
    }
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
    int pivot = scn.nextInt();
    partition(arr,pivot);
    print(arr);
  }

}
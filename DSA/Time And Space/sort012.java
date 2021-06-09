// 1. You are given an array(arr) containing only 0's, 1's, and 2's.
// 2. You have to sort the given array in increasing order and in linear time.
// Input Format
// An Integer N 
// arr1
// arr2..
// n integers
// Output Format
// Check the sample output and question video.


import java.io.*;
import java.util.*;

public class Main {

  public static void sort012(int[] arr){
    //write your code here
    
    
    int i=0,j=0,k=arr.length-1;
    //We only change values by shifting 0 to back, and 2 to right. 1 automatically stays in right place
    while(i<=k){ 
        if(arr[i]==0){ //value of arr[i] and arr[k] is unknown. 
            //Zero encountered, swap it with j
            swap(arr,i,j);
            i++; //move to next unknown value, as val at j is 1
            j++; //now we know that j idx has a zero, so we move forward
        }else if(arr[i]==1){
            i++; //make no changes for 1, move to next unknown
        }else if(arr[i]==2){
            swap(arr,i,k); //shift 2 at back, unknown value at k shifts are curr i value
            k--; //we know 2 is at k, so move back
        }
    }
    
    //UNOPTIMIZED APPROACH
    // int i=0,j=0,k=0;
    // while(i<arr.length){
    //     if(arr[i]==0){
    //         swap(arr,i,j);
    //         i++;
    //         j++;
    //     }else{
    //         i++;
    //     }
    // }
    // // j=0;
    // k=j;
    // while(j<arr.length){
    //     if(arr[j]==1){
    //         swap(arr,j,k);
    //         k++;
    //         j++;
    //     }else{
    //         j++;
    //     }
    // }
  }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping index " + i + " and index " + j);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void print(int[] arr){
    for(int i = 0 ; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for(int i = 0 ;i < n; i++){
      arr[i] = scn.nextInt();
    }
    sort012(arr);
    print(arr);
  }

}
// 1. You are given two sorted arrays(a,b) of integers.
// 2. You have to merge them and form one sorted array.
// 3. You have to do it in linear time complexity.
// Input Format
// An Integer n 
// a1
// a2..n integers
// An integer m
// b1
// b2..m integers
// Output Format
// Check the sample output and question video.




import java.io.*;
import java.util.*;

public class Main {

  public static int[] mergeTwoSortedArrays(int[] a, int[] b){
    //write your code here
    int n1=a.length;
    int n2=b.length;
    
    int ap=0;
    int bp=0;
    int cp=0;
    
    int c[] = new int[n1+n2];
    int small= a.length<b.length ? a.length: b.length;
    
    
    while(ap<n1 && bp<n2 ){
        if(a[ap]<=b[bp]){
            c[cp] = a[ap];
            ap++;cp++;
        }else{
            c[cp] = b[bp];
            bp++;cp++;
        }
    }
    
    while(ap<n1){
        c[cp]=a[ap];
        ap++;cp++;
    }
    
    while(bp<n2){
        c[cp]=b[bp];
        bp++;cp++;
    }

    return c;
    // for(int i =0; i<small;i++){
    //     if(a[ap] < b[bp]){
    //         c[i]=a[ap];
    //         ap++;
    //         cp++;
    //     }else{
    //         c[i]=b[bp];
    //         bp++;
    //         cp++;
    //     }
    // }
    
    // for(int i=small;i<c.length;i++){
    //     if(small==a.length){
    //         c[i] = b[bp];
    //         cp++;bp++;
    //     }else{
    //         c[i] = a[ap];
    //         cp++;ap++;
    //     }
    // }
    
    
  }

  public static void print(int[] arr){
    for(int i = 0 ; i < arr.length; i++){
      System.out.println(arr[i]);
    }
  }
  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] a = new int[n];
    for(int i = 0 ; i < n; i++){
      a[i] = scn.nextInt();
    }
    int m = scn.nextInt();
    int[] b = new int[m];
    for(int i = 0 ; i < m; i++){
      b[i] = scn.nextInt();
    }
    int[] mergedArray = mergeTwoSortedArrays(a,b);
    print(mergedArray);
  }

}
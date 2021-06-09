// 1. You are given an array(arr) of different dates in format DD-MM-YYYY.
// 2. You have to sort these dates in increasing order.
// Input Format
// An Integer N 
// arr1
// arr2..
// n integers
// Output Format
// Check the sample output and question video.


//Use radix sort to first sort days, then months, then years
// get day = date/1000000
// get month = (date/10000)%100
// get year = (date%10000)
import java.io.*;
import java.util.*;

public class Main {

  public static void sortDates(String[] arr) {
    // write your code here
    
    countSort(arr,1000000,100,32);//days
    countSort(arr,10000,100,13);//months
    countSort(arr,1,10000,2501);//years
    
    
  }

  public static void countSort(String[] arr,int div, int mod, int range) {
    // write your code here
    String ans[] = new String[arr.length];
    
    
    int farr[] = new int[range];
    for(int i=0;i<arr.length;i++){
        farr[Integer.parseInt(arr[i],10)/div%mod]++;
    }
    
    for(int i=1;i<farr.length;i++){
        farr[i]+=farr[i-1];
    }
    
    for(int i = arr.length-1 ; i >= 0 ; i--){
        int pos = farr[Integer.parseInt(arr[i],10)/div%mod] -1;
        
        ans[pos] = arr[i];
        farr[Integer.parseInt(arr[i],10)/div%mod]--;
    }
    
    for(int i = 0 ; i < arr.length ; i++){
        arr[i] = ans[i];
    }
    ///////////////////////////////////////////////
    // int freq[] = new int[range];
    // for(String vl : arr){
    //     int val=Integer.parseInt(vl,10);
    //     System.out.println(vl);
    //     freq[(val/div)%mod]++;
    // }
    // for(int i = 1 ; i < range ; i++){
    //     freq[i] += freq[i-1];
    // }
    
    // String res[] = new String[arr.length];
    // for(int i = arr.length-1 ; i >= 0 ; i--){
    //     String vl = arr[i];
    //     int val = Integer.parseInt(vl,10);
    //     int pos = (val/div)%mod;
    //     int place = freq[pos];
    //     res[place-1] = vl;
    //     freq[pos]--;
    // }
    
    // for(int i = 0 ; i < arr.length ; i++){
    //     arr[i] = res[i];
    // }
    
  }

  public static void print(String[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    String[] arr = new String[n];
    for (int i = 0; i < n; i++) {
      String str = scn.next();
      arr[i] = str;
    }
    sortDates(arr);
    print(arr);
  }

}
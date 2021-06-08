import java.io.*;
import java.util.*;

public class Main {

  public static void radixSort(int[] arr) {
    // write code here 
    //Works from least significant to most significant digits
    //sort full array based on least sig digit
    //Move towards left
    
    int max = Integer.MIN_VALUE;
    for(int val:arr){
        if(max<val){
            max=val;
        }
    }
    
    int count=0;
    while(max!=0){
        count++;
        max/=10;
    }
    
    for(int i=1, exp=1 ;i<=count;i++, exp*=10){
        countSort(arr,exp);
    }
  }

  public static void countSort(int[] arr, int exp) {
    // write code here
    int freq[] = new int[10];
    for(int vl : arr){
        freq[(vl/exp)%10]++;
    }
    for(int i = 1 ; i < 10 ; i++){
        freq[i] += freq[i-1];
    }
    
    int res[] = new int[arr.length];
    for(int i = arr.length-1 ; i >= 0 ; i--){
        int vl = arr[i];
        int pos = (vl/exp)%10;
        int place = freq[pos];
        res[place-1] = vl;
        freq[pos]--;
    }
    
    for(int i = 0 ; i < arr.length ; i++){
        arr[i] = res[i];
    }
    System.out.print("After sorting on " + exp + " place -> ");
    print(arr);
    
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
    radixSort(arr);
    print(arr);
  }

}
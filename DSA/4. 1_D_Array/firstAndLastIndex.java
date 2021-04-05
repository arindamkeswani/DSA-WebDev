// 1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing elements of array a.

// Asssumption - Array is sorted. Array may have duplicate values.

import java.io.*;
import java.util.*;

public class Main {




    public static int bin(int[] arr,int d){
        int lo=0;
        int hi=arr.length-1;
        
        int idx=-1;
        
        while(lo<=hi){
            int mid=(lo+hi)/2;
            
            if(d==arr[mid]){
                idx=mid;
                hi=mid-1;
            }
            else if(d<arr[mid]){
                hi=mid-1;
                // idx2=hi;
            }
            else{
                lo=mid+1;
                // idx2=lo;
            }}
        return idx;
            
    }
    
    public static int lbin(int[] arr,int d){
        int lo=0;
        int hi=arr.length-1;
        
        int idx=-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            
            if(d==arr[mid]){
                idx=mid;
                lo=mid+1;
            }
            else if(d<arr[mid]){
                hi=mid-1;
                // idx2=hi;
            }
            else{
                lo=mid+1;
                // idx2=lo;
            }
        
        }
        return idx;
    }

    
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner x=new Scanner(System.in);
        
        int n=x.nextInt();
        
        int[] arr=new int[n];
        
        for(int i=0;i<n;i++){
            arr[i]=x.nextInt();
        }
        
        int d=x.nextInt();
        
        
        int f=bin(arr,d);
        int l=lbin(arr,d);
        
        System.out.println(f);
        System.out.println(l);
    }

}
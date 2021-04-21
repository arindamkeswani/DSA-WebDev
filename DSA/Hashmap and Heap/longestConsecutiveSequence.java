// 1. You are given a number n, representing the size of array a.
// 2. You are given n numbers, representing elements of array a.
// 3. You are required to print the longest sequence of consecutive elements in the array (ignoring duplicates).

// Note -> In case there are two sequences of equal length (and they are also the longest), 
//then print the one for which the starting point of which occurs first in the array.

import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    
    Scanner x=new Scanner(System.in);
    int n=x.nextInt();
    
    int a[]=new int[n];
    for(int i=0;i<n;i++){
        a[i]=x.nextInt();
    }
    
    
    HashMap<Integer, Boolean> hm= new HashMap<>();
    
    
    //phase 1: make every point staring point
    
    for(int i=0;i<n;i++){
        hm.put(a[i], true);
    }
    
    
    //phase 2: remove non-starting points
    
    for(Integer key: hm.keySet()){
        if(hm.containsKey(key-1)){
            hm.put(key, false);
        }
    }
    
     
    //phase 3: check each starting point and update it along with size of sequence
    int maxSeqSp=-1; //starting point
    int maxSeqSize=0;
    for(int i=0;i<a.length;i++){
        int key= a[i];
        
        if(hm.get(key)==true ){
            int sp=key , size=1;
            
            while(hm.containsKey(sp+size)){
                size++;
            }
            
            if(size>maxSeqSize){
                maxSeqSize = size;
                maxSeqSp = sp;
            }
        }
    }
    
    for(int i=maxSeqSp; i<maxSeqSp+maxSeqSize; i++){
        System.out.println(i);
    }
 }

}
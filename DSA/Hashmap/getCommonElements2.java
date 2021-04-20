// 1. You are given a number n1, representing the size of array a1.
// 2. You are given n1 numbers, representing elements of array a1.
// 3. You are given a number n2, representing the size of array a2.
// 4. You are given n2 numbers, representing elements of array a2.
// 5. You are required to find the intersection of a1 and a2. To get an idea check the example below:
 
// if a1 -> 1 1 2 2 2 3 5
// and a2 -> 1 1 1 2 2 4 5
// intersection is -> 1 1 2 2 5

// Note -> Don't assume the arrays to be sorted. Check out the question video.

import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    HashMap<Integer, Integer> hm1= new HashMap<>();
    HashMap<Integer, Integer> hm2= new HashMap<>();
    
    Scanner x=new Scanner(System.in);
    int n1=x.nextInt();
    
    int a1[]=new int[n1];
    for(int i=0;i<n1;i++){
        a1[i]=x.nextInt();
    }
    
    
    for(int i=0;i<n1;i++){
        if(hm1.containsKey(a1[i])){
            hm1.put(a1[i] , hm1.get(a1[i]) + 1);
        }else{
            hm1.put(a1[i] , 1);
        }
        
    }
    
    
    int n2=x.nextInt();
    int a2[]=new int[n2];
    for(int i=0;i<n2;i++){
        a2[i]=x.nextInt();
    }
    
    
    // for(int i=0;i<n2;i++){
    //     if(hm1.containsKey(a2[i])){
    //         hm2.put(a2[i],1);
    //     }
    // }
    
    for(int i=0;i<n2;i++){
        if(hm1.containsKey(a2[i])){
            if(hm1.get(a2[i]) >0){
                System.out.println(a2[i]);
                hm1.put(a2[i],hm1.get(a2[i])-1 );
            }
            
            // hm1.remove(a2[i]);
        }
    }
 }

}
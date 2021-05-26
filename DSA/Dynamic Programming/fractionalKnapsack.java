// 1. You are given a number n, representing the count of items.
// 2. You are given n numbers, representing the values of n items.
// 3. You are given n numbers, representing the weights of n items.
// 3. You are given a number "cap", which is the capacity of a bag you've.
// 4. You are required to calculate and print the maximum value that can be created in the bag without overflowing it's capacity.
// Note1 -> Items can be added to the bag even partially. But you are not allowed to put same items again and again to the bag.
// Input Format
// A number n
// v1 v2 .. n number of elements
// w1 w2 .. n number of elements
// A number cap
// Output Format
// A decimal number representing the maximum value that can be created in the bag without overflowing it's capacity



import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner x= new Scanner(System.in);
        int n= x.nextInt();
        int v[]=new int[n];
        int w[]=new int[n];
        
        for(int i=0;i<n;i++){
            v[i]=x.nextInt();
        }
        for(int i=0;i<n;i++){
            w[i]=x.nextInt();
        }
        
        int cap=x.nextInt();
        
        System.out.println(fracKnapsack(v,w,cap,n));
    }
    
    public static class Pair implements Comparable<Pair>{
        int wt, val;
        double ratio;
        
        public int compareTo(Pair o){
            if(o.ratio<this.ratio){
                return -1;
            }else if(o.ratio==this.ratio){
                return 0;
            }else{
                return 1;
            }
            // return o.ratio - this.ratio;
        }
    }
    public static double fracKnapsack(int v[], int w[], int cap, int n){
        Pair items[] = new Pair[n];
        for(int i=0;i<n;i++){
            Pair p = new Pair();
            p.wt = w[i];
            p.val = v[i];
            p.ratio = (p.val * 1.0)/ p.wt;
            
            items[i] = p;
        }
        
        Arrays.sort(items);
        
        int idx =0;
        double tVal = 0;
        while(cap>0 && idx<items.length){
            if(items[idx].wt <= cap){
                cap-=items[idx].wt;
                tVal+=items[idx].val;
                idx++;
            }else{
                tVal += cap*items[idx].ratio;
                cap=0;
            }
        }
        return tVal;
        
    }
}




// 1. You are given a list of lists, where each list is sorted.
// 2. You are required to complete the body of mergeKSortedLists function. 
// The function is expected to merge k sorted lists to create one sorted list.


import java.io.*;
import java.util.*;

public class Main {
    
   public static class Pair implements Comparable<Pair>{
       int li, di, val;
       Pair(int li, int di, int val){
           this.li=li; //list index
           this.di=di; //data index
           this.val=val; //value
       }
       
       //this-o:minPriority
       //o-this:maxPriority
       public int compareTo(Pair o){
           //-ve,0,+ve
           return this.val-o.val; //will return value on the basis on value priority
       }
   }
   public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists){
      ArrayList<Integer> rv = new ArrayList<>();

      // write your code here
      PriorityQueue<Pair> pq=new PriorityQueue();
      for(int i=0;i<lists.size();i++){
          pq.add(new Pair(i,0,lists.get(i).get(0))); //storing the first value of each list
      }
        while(pq.size()>0){ //if there are more elements in the list, update their value
            Pair minPair = pq.remove();
            rv.add(minPair.val);
            
            if(minPair.di+1< lists.get(minPair.li).size()){
                minPair.di = minPair.di+1;
                minPair.val = lists.get(minPair.li).get(minPair.di);
                pq.add(minPair);
            }
        }
      return rv;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int k = Integer.parseInt(br.readLine());
      ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
      for(int i = 0; i < k; i++){
         ArrayList<Integer> list = new ArrayList<>();

         int n = Integer.parseInt(br.readLine());
         String[] elements = br.readLine().split(" ");
         for(int j = 0; j < n; j++){
            list.add(Integer.parseInt(elements[j]));
         }

         lists.add(list);
      }

      ArrayList<Integer> mlist = mergeKSortedLists(lists);
      for(int val: mlist){
         System.out.print(val + " ");
      }
      System.out.println();
   }

}
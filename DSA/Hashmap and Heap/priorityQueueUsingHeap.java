// 1. You are required to complete the code of our Priority Queue class using the heap data structure. Please watch the question video carefully. The theoretical details of required functionality is explained in detail there. Implement the functions to achieve what is explained in the theoretical discussion in question video.
// 2. Here is the list of functions that you are supposed to complete:
//     2.1. add -> Should accept new data.
//     2.2. remove -> Should remove and return smallest value, if available or print 
//      "Underflow" otherwise and return -1.
//      2.3. peek -> Should return smallest value, if available or print "Underflow" 
//      otherwise and return -1.
//      2.4. size -> Should return the number of elements available.
// 3. Input and Output is managed for you.


import java.io.*;
import java.util.*;

public class Main {

  public static class PriorityQueue {
    ArrayList<Integer> data;

    public PriorityQueue() {
      data = new ArrayList<>();
    }

    public void add(int val) {
      // write your code here
      data.add(val);
      upHeapify(data.size()-1);
    }
    
    public void upHeapify(int idx){
        if(idx==0){
            return;
        }
        int pidx = (idx-1)/2; //formula to reach parent index
        //child index can be found at (pidx*2+1 and at pidx*2+2)
        
        int cVal=data.get(idx);
        int pVal=data.get(pidx);
        
        if(cVal<pVal){
            data.set(pidx,cVal);
            data.set(idx,pVal);
            
            upHeapify(pidx);
        }
    }
    public int remove() {
      // write your code here
      if(data.size()==0){
          System.out.println("Underflow");
          return -1;
      }
      int val= data.get(0);
      data.set(0,data.get(data.size()-1)); //put last value in 0th position
      data.remove(data.size()-1); //remove last value
      downHeapify(0);
      return val;
    }
    
    public void downHeapify(int idx){
        int lidx = 2*idx + 1;
        int ridx = 2*idx + 2;
        
        int minIdx = idx;
        if(lidx<data.size() && data.get(lidx)<data.get(minIdx) ){ //first condition is to check whether element exists
            minIdx = lidx;
        }
        if(ridx<data.size() && data.get(ridx)<data.get(minIdx) ){
            minIdx = ridx;
        }
        
        if(minIdx!=idx){
            int val = data.get(idx);
            int minVal = data.get(minIdx);
            
            data.set(idx,minVal);
            data.set(minIdx,val);
            
            downHeapify(minIdx);
        }
    }
    public int peek() {
      // write your code here
      if(data.size()==0){
          System.out.println("Underflow");
          return -1;
      }
      return data.get(0);
    }

    public int size() {
      // write your code here
      return data.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    PriorityQueue qu = new PriorityQueue();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("add")) {
        int val = Integer.parseInt(str.split(" ")[1]);
        qu.add(val);
      } else if (str.startsWith("remove")) {
        int val = qu.remove();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("peek")) {
        int val = qu.peek();
        if (val != -1) {
          System.out.println(val);
        }
      } else if (str.startsWith("size")) {
        System.out.println(qu.size());
      }
      str = br.readLine();
    }
  }
}
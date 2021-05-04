// 1. You are required to complete the code of our Hashmap class. Please watch the question video carefully. 
// The theoretical details of required functionality is explained in detail there. 
// Implement the functions to achieve what is explained in the theoretical discussion in question video.
// 2. Input and Output is managed for you.


import java.io.*;
import java.util.*;

public class Main {

  public static class HashMap<K, V> {
    private class HMNode {
      K key;
      V value;

      HMNode(K key, V value) {
        this.key = key;
        this.value = value;
      }
    }

    private int size; // n
    private LinkedList<HMNode>[] buckets; // N = buckets.length

    public HashMap() {
      initbuckets(4);
      size = 0;
    }

    private void initbuckets(int N) {
      buckets = new LinkedList[N];
      for (int bi = 0; bi < buckets.length; bi++) {
        buckets[bi] = new LinkedList<>();
      }
    }
    
    //if key exists, gives its index inside bucket, otherwise return -1
    private int findNodeByKey(int bi, K key){
        LinkedList<HMNode> ll = buckets[bi];
        for(int idx = 0; idx<ll.size() ;idx++){
            HMNode node=ll.get(idx);
            
            if(key.equals(node.key)){
                return idx;
            }
        }
        
        return -1;
    }
    public void put(K key, V value) throws Exception {
      // write your code here
      int bi = hashFunc(key); //bucket index
      int di = findNodeByKey(bi, key); //data index
      
      if(di==-1){
          //insert
          buckets[bi].addLast(new HMNode(key,value));
          size++;
      }else{
          //update
          HMNode node = buckets[bi].get(di);
          node.value = value;
      }
      
      double lambda = (size*1.0)/buckets.length;
      
      if(lambda> 2.0){
          //re hash by increasing (doubling) size of buckets
          rehash();
      }
    }

    public V get(K key) throws Exception {
      // write your code here
      
      int bi = hashFunc(key); //bucket index
      int di = findNodeByKey(bi, key); //data index
      
      if(di==-1){
          return null;
      }else{
          //update
          HMNode node = buckets[bi].get(di);
          return node.value;
      }
    }

    public boolean containsKey(K key) {
      // write your code here
      int bi = hashFunc(key); //bucket index
      int di = findNodeByKey(bi, key); //data index
      
      if(di==-1){
          return false;
      }else{
          return true;
      }
      
    }

    public V remove(K key) throws Exception {
      // write your code here
      int bi = hashFunc(key); //bucket index
      int di = findNodeByKey(bi, key); //data index
      
      if(di==-1){
          return null;
      }else{
          //update
          HMNode node = buckets[bi].remove(di);
          size--;
          return node.value;
      }
    }

    public ArrayList<K> keyset() throws Exception {
      // write your code here
      ArrayList<K> list= new ArrayList<>();
      
      for(LinkedList<HMNode> ll : buckets){
          for(HMNode node : ll){
              list.add(node.key);
          }
      }
      return list;
    }

    public int size() {
      // write your code here
      return this.size;
    }
    
    //hashfunc(key) ==>gives destination bucket

    private int hashFunc(K key){
        int hc = key.hashCode();
        int bi = Math.abs(hc%buckets.length);
        return bi;
    }
    
    private void rehash() throws Exception{
        LinkedList<HMNode>[] oldbuckets = buckets;
        initbuckets(oldbuckets.length*2);
        
        size=0;
        for(LinkedList<HMNode> ll: oldbuckets){
            for(HMNode node:ll){
                put(node.key, node.value);
            }
        }
    }
   public void display() {
      System.out.println("Display Begins");
      for (int bi = 0; bi < buckets.length; bi++) {
        System.out.print("Bucket" + bi + " ");
        for (HMNode node : buckets[bi]) {
          System.out.print( node.key + "@" + node.value + " ");
        }
        System.out.println(".");
      }
      System.out.println("Display Ends");
  }
}

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    HashMap<String, Integer> map = new HashMap();

    String str = br.readLine();
    while (str.equals("quit") == false) {
      if (str.startsWith("put")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        Integer val = Integer.parseInt(parts[2]);
        map.put(key, val);
      } else if (str.startsWith("get")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.get(key));
      } else if (str.startsWith("containsKey")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.containsKey(key));
      } else if (str.startsWith("remove")) {
        String[] parts = str.split(" ");
        String key = parts[1];
        System.out.println(map.remove(key));
      } else if (str.startsWith("size")) {
        System.out.println(map.size());
      } else if (str.startsWith("keyset")) {
        System.out.println(map.keyset());
      } else if (str.startsWith("display")) {
        map.display();
      }
      str = br.readLine();
    }
  }
}
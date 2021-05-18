// 1. You are given a graph and a source vertex. The vertices represent computers and the edges 
//      represent length of LAN wire required to connect them.
// 2. You are required to find the minimum length of wire required to connect all PCs over a network. 
//      Print the output in terms of which all PCs need to be connected, and the length of wire between 
//      them.

// Note -> For output, check the sample output and question video.

import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      // write your code here
      //Use Primm's algo to downsize the graph by removing extra, lengthy edges
      //Djisktra on the other hand, finds least costly path from one point to other
      
        MST(graph);  
   }
    public static class MSTPair implements Comparable<MSTPair>{
       int vtx, wt, pvtx;
       String psf;
       MSTPair(int vtx, int wt, int pvtx){
           this.vtx = vtx; //vertex
           this.wt = wt; //weight of edge
           this.pvtx = pvtx; //parent vertex
       }
       public int compareTo(MSTPair o){ //for min priority queue
           return this.wt - o.wt;
       }
   }
   public static void MST(ArrayList<Edge>[] graph){ //Minimum Spannig tree
       PriorityQueue<MSTPair> pq = new PriorityQueue<>();
       pq.add(new MSTPair(0,0,-1)); //add initial/starting case
       
       boolean visited[] = new boolean[graph.length];
       while(pq.size()>0){
           MSTPair pair = pq.remove();
           
           if(visited[pair.vtx]==false){
              visited[pair.vtx]=true;
              
              if(pair.pvtx!=-1){
                System.out.println("["+pair.vtx+"-"+pair.pvtx+"@"+pair.wt+"]");    
              }
              
              for(Edge e:graph[pair.vtx]){
                  if(visited[e.nbr]==false){
                      pq.add(new MSTPair(e.nbr, e.wt,pair.vtx));
                  }
              }
           }
       }
   }
    
    
    
}
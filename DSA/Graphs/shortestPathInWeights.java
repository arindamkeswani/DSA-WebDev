// 1. You are given a graph and a source vertex. The vertices represent cities and the edges represent 
//     distance in kms.
// 2. You are required to find the shortest path to each city (in terms of kms) from the source city along 
//     with the total distance on path from source to destinations.

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

      int src = Integer.parseInt(br.readLine());
      // write your code here
      spw(graph, src);
      
   }
   
   public static class SPWPair implements Comparable<SPWPair>{
       int vtx, wsf;
       String psf;
       SPWPair(int vtx, int wsf, String psf){
           this.vtx = vtx;
           this.wsf = wsf;
           this.psf = psf;
       }
       public int compareTo(SPWPair o){ //for min priority queue
           return this.wsf - o.wsf;
       }
   }
   public static void spw(ArrayList<Edge>[] graph, int src ){
       PriorityQueue<SPWPair> pq = new PriorityQueue<>();
       pq.add(new SPWPair(src,0,""+src)); //add initial/starting case
       
       boolean visited[] = new boolean[graph.length];
       while(pq.size()>0){
           SPWPair pair = pq.remove();
           
           if(visited[pair.vtx]==false){
              visited[pair.vtx]=true;
              
              System.out.println(pair.vtx+" via "+pair.psf+" @ "+pair.wsf);
              for(Edge e:graph[pair.vtx]){
                  if(visited[e.nbr]==false){
                      pq.add(new SPWPair(e.nbr, pair.wsf+e.wt,pair.psf+e.nbr));
                  }
              }
           }
       }
   }
   
   
}
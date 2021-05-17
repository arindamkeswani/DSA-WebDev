// 1. You are given a graph.
// 2. You are required to find and print if the graph is cyclic.
// Input Format
// Input has been managed for you
// Output Format
// true if the graph is cyclic, false otherwise


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
      System.out.println(isCyclic(graph));
   }
   
   public static boolean isCyclic(ArrayList<Edge>[] graph){
       boolean visited[] = new boolean[graph.length];
       for(int v=0;v<graph.length; v++){
           if(visited[v]==false){
               boolean response= isCompCyclic(graph,v,visited); 
               if(response==true){ //component of curent vertex is cyclic
                   return true;
               }
           }
       }
       return false; //no component is cyclic
   }
   
   public static boolean isCompCyclic(ArrayList<Edge>[] graph, int src, boolean visited[]){
       Queue<Integer> queue = new ArrayDeque<>();
       
       queue.add(src); //add current vretex
       while(queue.size()>0){ 
           int fvtx= queue.remove();
           
           if(visited[fvtx] == false){ //if vertex is not visited 
               visited[fvtx]=true; //mark as visited
                
               for(Edge e:graph[fvtx]){ //traverse trough the vertex's connections
                   if(visited[e.nbr]==false){
                       queue.add(e.nbr);
                   }
               }
           }else{ //vtx is already visited
               return true;
           }
       }
       
       return false;
   }
   
 
   
}
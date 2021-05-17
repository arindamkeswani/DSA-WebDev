// 1. You are given a graph.
// 2. You are required to find and print if the graph is connected (there is a path from 
//      every vertex to every other).

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
      ArrayList<ArrayList<Integer>> res =gcc(graph); //get total number of components in the graph, if there is only one (Connected), then true, otherwise false
    //   System.out.println(res.size());
      if(res.size() == 1){
          System.out.println(true);
      }
      else{
          System.out.println(false);
      }
   }
   
   public static ArrayList<ArrayList<Integer>> gcc(ArrayList<Edge> graph[]){
       ArrayList<ArrayList<Integer>> allComps = new ArrayList<>();
       boolean visited[]=new boolean[graph.length];
       
       for(int vtx=0;vtx<graph.length;vtx++){
           if(visited[vtx]==false){ //if vertex is unvisited
               ArrayList<Integer> res= new ArrayList<>(); //store that group's result in this variable
               gcc(graph,vtx,res,visited); //adds all values of connected graphs to the list
               
               allComps.add(res);
           }
       }
       return allComps;
   }
   
   public static void gcc(ArrayList<Edge> graph[], int vtx, ArrayList<Integer> res, boolean visited[]){
       res.add(vtx); //add current vertex
       visited[vtx] = true; //mark as visited
       
       for(Edge e: graph[vtx]){ 
           if(visited[e.nbr]==false){ //is neighbour is unvisited
               gcc(graph,e.nbr,res,visited); //repeat procedure for neighbour
           }
       }
   }

}
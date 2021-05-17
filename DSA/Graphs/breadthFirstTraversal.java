// 1. You are given a graph, and a src vertex.
// 2. You are required to do a breadth first traversal and print which vertex is reached via which path, 
//      starting from the src.

// Note -> for output, check the sample output and question video.

import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
    public static class Pair{
        int vtx;
        String psf;
        
        Pair(int vtx, String psf){
            this.vtx= vtx;
            this.psf = psf;
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
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());

      // write your code here  
      bfs(graph, src);
      
   }
   
   public static void bfs(ArrayList<Edge>[] graph, int src){
       Queue<Pair> queue = new ArrayDeque<>();
       queue.add(new Pair(src,""+src)); //add source vertex
       
       boolean visited[] = new boolean[graph.length]; //to check visited vertices
       while(queue.size()>0){
           Pair fpair = queue.remove(); //get foremost element
           
           if(visited[fpair.vtx]==false){ //if vertex is unvisited
               visited[fpair.vtx]=true; //mark is as visited
               System.out.println(fpair.vtx+"@"+fpair.psf);
               
               for(Edge e:graph[fpair.vtx]){ //go through all neighbors of current vertex
                   if(visited[e.nbr]==false){ //if neighbour is not visited, add it to the queue
                       queue.add(new Pair(e.nbr, fpair.psf + e.nbr));
                   }
               }
           }
       }
   }
}
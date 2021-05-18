// 1. You are given a directed acyclic graph. The vertices represent tasks and edges represent 
//     dependencies between tasks.
// 2. You are required to find and print the order in which tasks could be done. The task that should be 
//     done at last should be printed first and the task which should be done first should be printed last. 
//     This is called topological sort. Check out the question video for details.

// Topological sort -> A permutation of vertices for a directed acyclic graph is called topological sort if 
//                                     for all directed edges uv, u appears before v in the graph

// Note -> For output, check the sample output and question video.



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
      }

      // write your code here
      boolean visited[] = new boolean[graph.length];
      Stack<Integer> st = new Stack<>();
      
      for(int v=0; v<vtces; v++){ //go over each vetrex to check its depedencies (useful in case of multiple components too)
          if(visited[v]==false){
            topologicalSort(graph, v, visited, st);
          }
      }
      while(st.size()>0){ //print result
          System.out.println(st.pop());
      }
   }
   
   public static void topologicalSort(ArrayList<Edge>[] graph, int src, boolean visited[], Stack<Integer> st ){
       visited[src]=true;//mark as visited
       
       for(Edge e:graph[src]){ 
           if(visited[e.nbr]==false){ //if neighour is unvisited
               topologicalSort(graph, e.nbr, visited, st); //do post order work and sort all dependencies topologically
           }
       }
       
       st.push(src); //push in post order so that the independent/resolved ones are pushed on stack only
   }
   

}
// 1. You are given a graph, and a source vertex.
// 2. You are required to do a iterative depth first traversal and print which vertex is reached via which 
//      path, starting from the source.

// Note -> For output, check the sample output and question video. Iterative depth first traversal 
//                should mimic "Reverse preorder" i.e. nbr with highest value should be visited first and 
//                should be printed on the way down in recursion.



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
         graph[v2].add(new Edge(v2, v1));
      }

      int src = Integer.parseInt(br.readLine());

      // write your code here  
       dfsIter(graph,src);  
   }
   
   public static class DFSPair{
       int vtx;
       String psf;
       DFSPair(int vtx,String psf){
           this.vtx = vtx;
           this.psf = psf;
       }
   }
   public static void dfsIter(ArrayList<Edge>[] graph,int src){
       Stack<DFSPair> st = new Stack<>();
       st.push(new DFSPair(src,src+""));
       
       
       boolean visited[] = new boolean[graph.length];
       
       while(st.size()>0){
           DFSPair top = st.pop();
           
           if(visited[top.vtx] == false){ //if node is not visited, print path and mark node as visited
               visited[top.vtx] = true;
               System.out.println(top.vtx+"@"+top.psf);
               
               for(Edge e:graph[top.vtx]){
                   if(visited[e.nbr] == false){
                       st.push(new DFSPair(e.nbr,top.psf+e.nbr)); //is neighbour of is unvisited, push it in stack and add current node to its path
                   }
               }
           }
       }
   }

   

}
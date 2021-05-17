// 1. You are given a graph.
// 2. You are required to find and print if the graph is bipartite

// Note -> A graph is called bipartite if it is possible to split it's vertices in two sets of mutually 
//                exclusive and exhaustive vertices such that all edges are across sets.
// Input Format
// Input has been managed for you
// Output Format
// true if the graph is bipartite, false otherwise

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
      System.out.println(isBipartite(graph));
   }
   
   public static boolean isBipartite(ArrayList<Edge>[] graph){
          boolean visited[]=  new boolean[graph.length];
          for(int v = 0 ; v < graph.length ; v++){
              if(visited[v] == false){
                  boolean res = isCompBipartite(graph,v,visited);
                  if(res == false){
                      return false;
                  }
              }
          }
 
          return true;
      }
    public static class BPair{
        int vtx,level;
        BPair(int vtx,int level){
            this.vtx = vtx;
            this.level = level;
        }
    }
   public static boolean isCompBipartite(ArrayList<Edge>[] graph,int src,boolean visited[]){
        Queue<BPair> queue= new ArrayDeque<>();
        queue.add(new BPair(src,0));
        HashMap<Integer,Integer> hm = new HashMap<>();
        while(queue.size() > 0){
            BPair pair = queue.remove();
 
            if(visited[pair.vtx] == true){
                if(pair.level%2 != hm.get(pair.vtx)%2){ //is the same element is in differenct groups
                    return false;
                }
            }else{
                hm.put(pair.vtx,pair.level);
                visited[pair.vtx] = true;
 
                for(Edge e : graph[pair.vtx]){
                    if(visited[e.nbr] == false){
                        queue.add(new BPair(e.nbr,pair.level+1));
                    }
                }
            }
        }
        return true;
    }
   
}




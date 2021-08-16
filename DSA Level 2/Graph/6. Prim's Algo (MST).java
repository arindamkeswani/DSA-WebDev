import java.util.*;
import java.lang.*;

class Main{

    public static class Edge{
        int src, nbr, wt;

        Edge(int src, int nbr, int wt){
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }


    public static class Pair implements Comparable<Pair>{
        int vtx, wt;
        Pair(int vtx, int wt){
            this.vtx=vtx;
            this.wt=wt;
        }

        public int compareTo(Pair o){
            return this.wt-o.wt;
        }
    }
    public static long solve(ArrayList<Edge>[] graph){
        
        int nVtces=graph.length;
        

        PriorityQueue<Pair> pq=new PriorityQueue<>();//stores {nbr, wt}
        pq.add(new Pair(1,0));
        boolean vis[]=new boolean[nVtces]+1;

        long ans=0;

        while(pq.size()>0){
            Pair rem=pq.remove(); //get min weight edge

            if(vis[rem.vtx]==true){//check if it is already visited
                continue;
            }

            vis[rem.vtx]=true; //mark as visited
            ans+=rem.wt;

            for(Edge e: graph[rem.vtx]){
                if(vis[e.nbr]==false){
                    pq.add(new Pair(e.nbr, e.wt));
                }
            }
        }

        return ans;
    }
    
    public static void main(String[] args) throws java.lang.Exception{
        Scanner scn = new Scanner();
        int nVtces=scn.nextInt();
        int nEdges= scn.nextInt();

        ArrayList<Edge>[] graph= new ArrayList[nVtces];

        for(int i=0; i<=nVtces; i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<nEdges; i++){
            int v1=scn.nextInt();
            int v2=scn.nextInt();
            int wt=scn.nextInt();

            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }

        System.out.println(solve(graph));
    }    
}
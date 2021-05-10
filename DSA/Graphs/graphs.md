.Graphs have vertices and edges, edges connect 2 vertices
__________
.If you can go from one vertice to another and come back via the same edge, it is undirected
__________
.If you can only go from one vertice to another and not come back via the same edge, it is directed
__________
.Degree:
Number of edges a vertice is conected to

.Way to create a graph
Make an array
__________
Every index of array represents an arraylist
(0th index will have all information related to edges originating from 0th vertex)
__________
ArrayList <Edge> [] graph
[Edge has a source, a destination, weight]
Eg:
idx:src-dest-wt
0:0-1-10|0-3-40
__________
ArrayList has default values as null, so initialize an arraylist inside every index
__________
Output will give an error in printing, so override the toString() function to format it
_______________
import java.util.*;
public class Intro{
    public static class Edge{
        int src , dest , wt;
 
        Edge(int src , int dest , int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
 
        public String toString(){
            return src+" -> "+dest+" @ "+wt;
        }
    }
    public static void main(String[] args) {
        ArrayList<Edge> graph[] = new ArrayList[7];
 
        for(int idx = 0 ; idx < graph.length ; idx++){
            graph[idx] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,3,40));
 
        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,2,10));
 
        graph[2].add(new Edge(2,1,10));
        graph[2].add(new Edge(2,3,10));
 
        graph[3].add(new Edge(3,0,40));
        graph[3].add(new Edge(3,2,10));
        graph[3].add(new Edge(3,4,10));
 
        graph[4].add(new Edge(4,3,10));
        graph[4].add(new Edge(4,5,3));
        graph[4].add(new Edge(4,6,8));
 
        graph[5].add(new Edge(5,6,3));
        graph[5].add(new Edge(5,4,3));
 
        graph[6].add(new Edge(6,5,3));
        graph[6].add(new Edge(6,4,8));
 
        for(int idx = 0 ; idx < graph.length ; idx++){
            System.out.println(idx +"-->"+graph[idx]);
        }      
    }
}
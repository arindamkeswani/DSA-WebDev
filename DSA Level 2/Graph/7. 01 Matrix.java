
Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.

The distance between two adjacent cells is 1.
Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]

Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
______________________________
class Solution {
    public static class Pair{
       int r, c, d;
       Pair(int r, int c, int d){
           this.r=r;
           this.c=c;
           this.d=d;
       }
   }
   public int[][] updateMatrix(int[][] mat) {
       //Store all 0s in a queue
       
       
      Queue<Pair> queue=new ArrayDeque<>();
       int res[][]= new int[mat.length][mat[0].length];
       
       for(int r=0;r<mat.length; r++){
           for(int c=0; c<mat[0].length; c++){
               if(mat[r][c]==0){
                   queue.add(new Pair(r,c,0));
               }
           }
       }
       
       //search in all 4 directions for a 1
       int dir[][]={{-1,0},{0,1},{+1,0},{0,-1}};
       
       while(queue.size()>0){
           Pair rem = queue.remove();
           res[rem.r][rem.c]=rem.d;
           
           for(int d=0;d<4;d++){
               int rdash = rem.r + dir[d][0], cdash = rem.c + dir[d][1];
               //check validity
               if(rdash<0 || cdash<0 || rdash>=mat.length || cdash>= mat[0].length || mat[rdash][cdash]!=1){
                   continue;
               }

               //mark curr place as 0 as it is processed
               mat[rdash][cdash]=0;
               
               //inpur new 1 position found in queue with +1 distance
               queue.add(new Pair(rdash, cdash, rem.d+1));
           }
       }
       
       return res;
   }
}
// 1. You are given a 2d array where 0's represent land and 1's represent water. 
//      Assume every cell is linked to it's north, east, west and south cell.
// 2. You are required to find and count the number of islands.

import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }

      // write your code here
      System.out.println(noOfIsland(arr));
   }
   
   public static int noOfIsland(int arr[][]){
       int nr = arr.length;
       int nc = arr[0].length;
       boolean visited[][] = new boolean[nr][nc];
       int count=0;
       for(int i=0;i<nr;i++){
           for(int j=0;j<nc;j++){
                if(arr[i][j] == 0 && visited[i][j]==false){ //if it is land and is unvisited
                    gcc(arr,visited,i,j);
                    count++; //add island
                }
            }
       }   
       return count;
   }
   
   public static void gcc(int arr[][], boolean visited[][], int r, int c){
       if(r<0 || c<0 || r>=arr.length || c>=arr[0].length || arr[r][c]==1 || visited[r][c]==true) { //if we go out of bounds, or in water, or if already visited
           return;
       }
       visited[r][c]=true;
       gcc(arr, visited, r-1,c); //north
       gcc(arr, visited, r,c+1); //east
       gcc(arr, visited, r,c-1); //west
       gcc(arr, visited, r+1,c); //south
       
   }

}
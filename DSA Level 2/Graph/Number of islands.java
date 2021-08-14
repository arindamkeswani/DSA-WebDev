Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

________________________


class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean visited[][] = new boolean[m][n];
        int count=0;
        
        for(int r=0;r<m;r++){
            for(int c=0; c<n; c++){
                if(grid[r][c] =='1' && visited[r][c]==false){//found unvisited land/island
                    count++;
                    helper(grid, r, c);
                }
            }
        }
        
        return count;
    }
    
    static int dir[][]={ {-1,0}, {0, 1}, {1,0}, {0,-1} }; //N, E, W, S
    private static void helper(char grid[][], int r, int c){
            
        grid[r][c]='2'; //mark;
        
        for(int d=0;d<4;d++){
            int rowDash = r + dir[d][0];
            int colDash = c + dir[d][1];
            
            if(rowDash <0 || colDash<0 || rowDash>=grid.length || colDash>=grid[0].length || grid[rowDash][colDash]!='1'){
                continue;
            }
            helper(grid, rowDash, colDash);
        }
            
    }
}
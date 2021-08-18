You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.


Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.

Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: All 1s are either on the boundary or can reach the boundary.
________________________

class Solution {
    public int numEnclaves(int[][] grid) {
        
        int count=0;

        //using these in place of static variables
        int sizeOfIsland[];
        boolean connToBoundary[];
        for(int r=0; r< grid.length; r++){
            for(int c=0;c<grid[0].length;c++){
                
                if(grid[r][c]==1){
                    
                    sizeOfIsland = new int[]{0};
                    connToBoundary = new boolean[]{false};
                    // count++;
                    helper(grid, r, c, sizeOfIsland, connToBoundary);
                    
                    if(connToBoundary[0] == false){ //if curr island is not connected to boundary, add number of lands in it
                        count+=sizeOfIsland[0];
                    }
                }
            }
        }
        
        return count;
    }
    
    static int dir[][] = {{-1,0}, {0,1}, {1,0}, {0,-1} };
    private static void helper(int[][] grid, int r, int c, int sizeOfIsland[], boolean connToBoundary[]){
        
        if(r==0 || c==0 || r==grid.length-1 || c==grid[0].length-1){ //if island is connected to boundary
            connToBoundary[0]=true;
        }
        grid[r][c]=2;
        sizeOfIsland[0]++;
        
        for(int d=0; d<4; d++){
            int rowDash = r+dir[d][0];
            int colDash = c+dir[d][1];
            
            if(rowDash<0 || colDash<0 || rowDash>= grid.length || colDash>= grid[0].length || grid[rowDash][colDash]!=1){
                continue;
            }
            
            helper(grid, rowDash, colDash, sizeOfIsland,connToBoundary);
        }
        
    }
}
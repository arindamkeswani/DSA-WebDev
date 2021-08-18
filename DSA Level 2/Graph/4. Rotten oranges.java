You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

________________________



class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue = new ArrayDeque<>();
        int nFreshOranges=0;
        
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]==1){
                    nFreshOranges++;
                }else if(grid[r][c]==2){
                    queue.add(new Pair(r,c));
                }
            }
        }
        
        int level=0;
        int dir[][]={{1,0},{0,-1},{-1,0},{0,1}};
        while(queue.size()>0){
            
            // level++;
            int lSize = queue.size();
            
            while(lSize-- >0){
                Pair tmp=queue.remove();
                
                
                for(int i=0;i<4; i++){
                    int rdash=tmp.row + dir[i][0];
                    int cdash=tmp.col + dir[i][1];
                    
                    if(rdash<0 || cdash<0 || rdash >=grid.length || cdash>=grid[0].length || grid[rdash][cdash]!=1){
                        continue;
                    }
                    
                    nFreshOranges--;
                    grid[rdash][cdash]=2;
                    
                    queue.add(new Pair(rdash, cdash));
                }
            }
            if(queue.size()!=0){
                level++;
            }
            
        }
        
        
        if(nFreshOranges==0){
            return level;
        }
        
        return -1;
  
    }
    
    
    public class Pair{
        int row, col;
        Pair(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
}
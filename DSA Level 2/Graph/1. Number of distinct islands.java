Number of distinct islands that have a different kind of structure
________________________

class Solution{
    public int numDistinctIslands(int[][] grid){
        HashSet<String> set = new HashSet<>();
        StringBuilder psf;

        for(int r=0; r<grid.length; r++){
            for(int c=0;c<grid[0].length; c++){
                if(grid[r][c] ==1){
                    psf = new StringBuilder("X"); //eter starting point
                    helper( grid, r,c psf);
                    set.add(psf.toString());
                }
            }
        }

        return set.size();
    }

    private static void helper(intp[][] grid, int r, int c, StringBuilder psf){
        grid[r][c] = 2;
        
        if(r-1>=0 && grid[r-1][c]==1){ //when going N is feasible (valid area + land)
            psf.append("N");
            helper(grid, r-1, c, psf);
        }

        if(c+1<grid[0].length && grid[r][c+1]==1){ //when going E is feasible (valid area + land)
            psf.append("E");
            helper(grid, r, c+1, psf);
        }

        if(c-1>=0 && grid[r][c-1]==1){ //when going W is feasible (valid area + land)
            psf.append("W");
            helper(grid, r, c-1, psf);
        }

        if(r+1<grid.length && grid[r+1][c]==1){ //when going S is feasible (valid area + land)
            psf.append("S");
            helper(grid, r+1, c, psf);
        }
    }
}
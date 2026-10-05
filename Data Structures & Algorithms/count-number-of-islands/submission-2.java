class Solution {
    public int numIslands(char[][] grid) {
       int row = 0;
       int col = 0;
       int numIslands = 0;
       for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[i].length; j++) {
            if (grid[i][j] == '1') {
                numIslands++;
                dfs(grid, i, j);
            }
        }
       }
       return numIslands;
    }

    private static void dfs (char[][] g, int r, int c) {
        if (r < 0 || r >= g.length || c < 0 || c >= g[r].length || g[r][c] == '0') {
            return;
        }

        g[r][c] = '0';
        
        dfs(g, r+1, c);
        dfs(g, r-1, c);
        dfs(g, r, c+1);
        dfs(g, r, c-1);
    }
}

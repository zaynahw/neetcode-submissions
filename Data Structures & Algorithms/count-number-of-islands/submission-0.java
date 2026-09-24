class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    count++;
                    dfs(grid, row, col);
                }
            }
        }

        return count;
    }

    private static void dfs (char[][] g, int r, int c) {
        if (r >= g.length || r < 0 || c >= g[r].length || c<0 || g[r][c] == '0'){
            return;
        } else {
            g[r][c] = '0';
        }
        dfs(g, r+1, c);
        dfs(g, r-1, c);
        dfs(g, r, c+1);
        dfs(g, r, c-1);
    }
}

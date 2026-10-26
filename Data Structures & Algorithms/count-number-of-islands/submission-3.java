class Solution {
    public int numIslands(char[][] grid) {
       int count = 0;
       for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    processIsland(grid, r, c);
                }
            }
       }
       return count;
    }

    private static void processIsland(char[][] g, int r, int c) {
        int[][] directions = {
            {-1, 0},
            {1, 0}, 
            {0, -1},
            {0, 1}
        };
        if (r < 0 || r >= g.length || c < 0 || c >= g[r].length || g[r][c] == '0') {
            return;
        }
        g[r][c] = '0';
        for (int[] dir : directions) {
            processIsland(g, r + dir[0], c + dir[1]);
        } 
    }

    
}

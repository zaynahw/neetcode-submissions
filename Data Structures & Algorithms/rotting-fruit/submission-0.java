class Solution {
    public int orangesRotting(int[][] grid) {
        int timeCount = 0;
        int fresh = 0;
        Queue<int[]> line = new LinkedList<>();
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 2) {
                    line.add(new int[] {r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        boolean infect = false;
        
        while (!line.isEmpty()) {
            int size = line.size();

            int directions[][] = {
                {1, 0},
                {-1,0},
                {0,1},
                {0,-1}
            };

            infect = false;

            for (int i=0;i<size;i++) {
                int[] curr = line.remove();
                int row = curr[0];
                int col = curr[1];
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[newRow].length || grid[newRow][newCol] == 2 || grid[newRow][newCol] == 0) {
                        continue;
                    } else {
                        grid[newRow][newCol] = 2;
                        line.add(new int[] {newRow, newCol});
                        infect = true;
                        fresh--;
                    }
                }
            }
            if (infect) {
                timeCount++;
            }
        }

        if (fresh > 0) {
            return -1;
        }
        return timeCount;
    }

}

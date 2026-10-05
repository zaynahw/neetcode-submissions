class Solution {
    public int orangesRotting(int[][] grid) {
        int timeCount = 0;
        int fresh = 0;
        Queue<int[]> line = new LinkedList<>();

        // first go through the grid and add rotten to the queue,
        // count freshes if its fresh
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 2) {
                    line.add(new int[] {r, c});
                } else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        // this will check if u infected during a round
        // if u infect, then u increment timeCount by 1 since u infected
        boolean infect = false;

        // keep removing rotten from queue until done
        while (!line.isEmpty()) {
            // want loop to go as long as the original size
            int size = line.size();

            //easier method of looking at all directions
            int directions[][] = {
                {1, 0},
                {-1,0},
                {0,1},
                {0,-1}
            };

            // resets infect each round
            infect = false;

            for (int i=0;i<size;i++) {
                int[] curr = line.remove();
                int row = curr[0];
                int col = curr[1];
                // check for each adjacent direction
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    // check if invalid or already infected
                    if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[newRow].length || grid[newRow][newCol] == 2 || grid[newRow][newCol] == 0) {
                        continue;
                    } else {
                        // infect, add to queue, mark infect marker, decrement fresh num
                        grid[newRow][newCol] = 2;
                        line.add(new int[] {newRow, newCol});
                        infect = true;
                        fresh--;
                    }
                }
            }

            // because u infected this round, u can count
            if (infect) {
                timeCount++;
            }
        }

        // despite processing all rotten, there is some fresh left
        // therefore, they are unreachable
        if (fresh > 0) {
            return -1;
        }
        return timeCount;
    }

}

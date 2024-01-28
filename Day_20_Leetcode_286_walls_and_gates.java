/*
Approach: 
1. The problem is about the connected components that can be visited. 
2. So we're using BFS here.
3. We'll take a 2d matrix called visited to mark the index as visited. 
4. We'll traverse through the rooms matrix to find the occurrence of gates =0; and add those to queue, and at the same time marking those as visited. 
5. Now, we'll run a while loop 
6. For a defined q size, at level 1, we'll poll the elements from the Queue, and check for its four directional neighbors. 
7. We'll check boundry conditions, also if neighbor is visited, and also if it's not infinity; then only we'll add the neighbor coordinates to the queue.once we're are done iterating through the current size of the Queue, we'll just increment the level. 

TC: O(m*n) - 2 pass
SC: Queue Space, Visited matrix space./*/

class Solution {
    public void wallsAndGates(int[][] rooms) {
        // base case
        if (rooms == null)
            return;

        int m = rooms.length;
        int n = rooms[0].length;

        int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new int[] { i, j });
                    visited[i][j] = true; // marking visited.
                }
            }
        }
        // added all the gates to matrix.
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int[] curr = q.poll();
                // check into all four direction
                for (int[] dir : dirs) {
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];

                    // boundry chek and visited check before adding to the result
                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && !visited[nr][nc] && rooms[nr][nc] == 2147483647) {
                        rooms[nr][nc] = level;
                        visited[nr][nc] = true;
                        q.add(new int[] { nr, nc });
                    }
                }
            }
            level++;
        }
        return;
    }
}
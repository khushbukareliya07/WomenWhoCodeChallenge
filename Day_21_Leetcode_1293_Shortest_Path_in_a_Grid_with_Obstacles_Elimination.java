/*
Approach: 
BFS: 
1. at every point, we have k obstacles we can remove. So, if we just mark one position as visited, there could be chances, that when that element comes in the path from other directions, it could have less obstacles, and still can give us minimum path. 
2. In th traditional BFS, once we mark anything, we are not visiting it again, ut here, we have to visit elemnt based on available obstacles to explore at the path. 
3. So, let say we have k=2;  at particular element, when I reach, the obstacle I'm carrying till here, is also 2! Now, from the other path, I reach the same element, and i'm carrying the obstacle as let say 1! That means at the current position, I can have possible path that I can explore with less obstacles on my way to destinations. so basically here, we are doing DFS for element with K times at max!!

How to implement it
1. We're taking a matrix as visited, and marking all the intial obstacles at 99999 - amx value. 
2. We have to start from position (0,0); so we'll add that ndex into queue, along with obstacle used. 
3. We are taking a que with type of int[]; where index 0,1 represent the position, while index2 represents the obstacle use 
4. for the intial position, we'll not have any obstacles, so we're amrking visited[0][0] =0.
5.We'll also have a move variable defined.
6. Traditional BFS 
7. We take the size of the queue to iterate from! Whenever this for-loop is exhausted, we increment move. 
8. We'll poll the current element, extract the current obstacles. 
9. Go through the direction array, as we have to add neighbors from all four directions
10. Check the boundary conditions on new row, new column. 
11. Also, if our current visited[nr][nc] has greater value than obstacle, i.e. at the current (nr,nc) position; I can still try to explore other combination with new (less) obstacle values.
12. So, we'll add this new (nr,nc) position to Queue, and also we'll saved new obstacle value in the visited[nr][nc]. 
13.At any point of adding to the queue, we reach to the last position of the grid, we can just return the level. 
14. If we never reach to point 13; that means we have no way to reach to the destination, and we can just return -1.

TC: O(mn)
SC: O(mn)

*/

class Solution {
    public int shortestPath(int[][] grid, int k) {
        // base case
        if (grid == null)
            return -1;
        if (grid[0][0] == 1)
            return -1;
        int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        int m = grid.length;
        int n = grid[0].length;

        if (m == 1 && n == 1)
            return grid[0][0] == 0 ? 0 : -1;
        int[][] visited = new int[m][n]; // default value is 0;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = 99999; // maximum value at the visited index.
            }
        }
        q.add(new int[] { 0, 0, 0 });
        visited[0][0] = 0; // marking obstacles here

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                // 0, 1 cordintes, 2- k's value

                // System.out.print(" "+curr[0]+ " "+curr[1]);
                // System.out.println();
                int ob = curr[2];

                for (int[] dir : dirs) {
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];

                    if (nr == m - 1 && nc == n - 1)
                        return level + 1;
                    // check bounds
                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && visited[nr][nc] > ob) {
                        // obstacles
                        if (grid[nr][nc] == 1) {
                            if (ob < k) {
                                visited[nr][nc] = ob + 1; // marking ob as visited
                                q.add(new int[] { nr, nc, ob + 1 });
                            }
                        } else // always 0
                        {
                            visited[nr][nc] = ob;
                            q.add(new int[] { nr, nc, ob });
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
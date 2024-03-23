/** TC: O(V+E), SC - same */
// Graph coloring method!
// child should have different color than parent. if they collide at any point,
// graph is not bipartite.
class Solution {
    int[] colors;
    boolean bp_flag;

    public boolean isBipartite(int[][] graph) {
        if (graph == null)
            return false;

        int m = graph.length; // this gives total length - vertices
        colors = new int[m];

        // red - 1, blue is 2
        // intialize colors with -1;

        Arrays.fill(colors, -1);

        // flag that says if we found breaking conditions
        bp_flag = true;
        // traverse over all m vertices
        for (int i = 0; i < m; i++) {
            if (colors[i] == -1) {
                dfs(graph, i); // i represents v
                if (!bp_flag)
                    return false;
            }

        }
        return bp_flag;
    }

    private void dfs(int[][] graph, int vertex) {
        // base case

        // logic
        // 1.mark child nodes with color
        int n = graph[vertex].length;
        for (int i = 0; i < n; i++) {
            int curr = graph[vertex][i];
            if (colors[curr] == -1) {
                // graph[vertex][i] = 0th node -> [1,2,3]
                colors[curr] = colors[vertex] == 1 ? 2 : 1;
                dfs(graph, curr);
            } else // it already has color
            {
                if (colors[curr] == colors[vertex]) {
                    bp_flag = false;
                    return;
                }

            }

        }
    }
}
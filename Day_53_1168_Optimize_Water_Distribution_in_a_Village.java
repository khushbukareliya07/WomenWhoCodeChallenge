//TC: O(V+E) (E log E) + O(V)
//SC: O(V) + O(E) + Recursive stack O(V)

class Solution {
    int[] uf;
    List<int[]> edges;

    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {

        uf = new int[n + 1];

        // parent assignment, initially they are their own parents
        for (int i = 1; i <= n; i++) // TC: O(V)
        {
            uf[i] = i;
        }

        // form edges
        edges = new ArrayList<>();

        // connecting dummy village
        for (int i = 1; i <= n; i++) // TC: O(V)
        {
            edges.add(new int[] { 0, i, wells[i - 1] });
        }

        // pipe edges
        for (int[] pipe : pipes) {
            edges.add(pipe);
        }
        // sort
        Collections.sort(edges, (a, b) -> a[2] - b[2]); // TC: O(V+E)

        int result = 0;
        // go over edges,unionize in group

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            int px = findParent(x);
            int py = findParent(y);

            // if not equal
            if (px != py) {
                result += edge[2];
                uf[py] = px; // parent of one group surrenders to another group
            }
        }
        return result;
    }

    private int findParent(int x) {
        if (uf[x] != x) {
            return findParent(uf[x]);
            // uf[x] = findParent(uf[x]);
        }

        // parents are same
        return uf[x];
    }
}

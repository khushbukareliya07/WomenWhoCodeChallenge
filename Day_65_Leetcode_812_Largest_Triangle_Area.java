//TC: O(n^3) - Slightly Optimized Approach!
//sc: O(1)
class Solution {

    public double largestTriangleArea(int[][] points) {
        // base case
        if (points == null || points.length == 0)
            return 0.0;
        double largestArea = Integer.MIN_VALUE;
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] p = points[i];
                int[] q = points[j];
                double temp = (p[0] * q[1]) - (p[1] * q[0]);
                for (int k = i + 1; k < points.length; k++) {

                    int[] r = points[k];

                    double area = Math.abs(temp + (q[0] * r[1] + r[0] * p[1]) - (q[1] * r[0] + r[1] * p[0]));
                    largestArea = Math.max(largestArea, area);
                }
            }
        }
        return largestArea / 2.0;
    }
}
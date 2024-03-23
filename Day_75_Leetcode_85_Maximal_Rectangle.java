//this is just a histogram problem,
/*
1. Take oene row, find area
2. add second row when find 1, and find max area for that and so on. 
TC: O(m*n) * O(2n)
sc:O(n) arr + O(n) stack
*/

class Solution {
    public int maximalRectangle(char[][] matrix) {

        int result = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[n];
        int i = 0;
        // run through the first row, till m
        while (i < m) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    arr[j] += 1;

                } else {
                    arr[j] = 0;
                }
            }
            // after building the entire row - find hostogram - largest area
            result = Math.max(result, findHistogram(arr));

            // move to next row
            i++;
        }
        return result;
    }

    // copying logic from histogram!
    private int findHistogram(int[] heights) {
        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(-1);
        int len = heights.length;
        int area = 0, maxArea = 0, i = 0;

        while (i < len) // for(; i<n;)
        {
            // peek at the stack, and push the value if higher
            if (indexStack.peek() == -1 || heights[i] > heights[indexStack.peek()]) {
                indexStack.push(i);
                i++;
            } else // resolve the stack until if condition is wrong, basically heights[i] < peeking
                   // index's height
            {
                // popped current bigger height index
                int popped = indexStack.pop();
                // width * height of popped says min height till now
                area = (i - indexStack.peek() - 1) * heights[popped];
                maxArea = Math.max(area, maxArea);
            }

        }

        // resolve the rest of the stack
        while (indexStack.size() > 1) // we dont want to consider last index in resolving
        {
            int popped = indexStack.pop();
            area = (i - indexStack.peek() - 1) * heights[popped];
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
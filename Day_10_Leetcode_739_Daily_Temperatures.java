//TC: O(n*n)
//SC: O(n)

//Approach-1
/*Brute force
for every curr value, we'll run a loop from enxt element till n. 
exhausted.
*/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // base case
        if (temperatures == null)
            return new int[] {};
        int n = temperatures.length;
        int[] result = new int[n];
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            int curr = temperatures[i];
            int j = i + 1;
            while (j < n) {
                if (j < n && curr < temperatures[j]) {
                    result[i] = (j) - i;
                    break;
                } else
                    j++;
            }
        }
        return result;
    }
}

// Approach-2
/*
 * Monotonicall decreasing stack
 * 1. if stack is not empty, peek at the stack, see if the temp att hat index is
 * less than the curr one.
 * 2. if so, update the result[peeked] = curridx- peeked
 * and keep repeating until we find breach at step 1.
 * 3. othwerwise we add the index to stack
 */

// TC: O(n)
// SC: O(n) //stack space

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // base case
        if (temperatures == null)
            return new int[] {};

        int n = temperatures.length;
        int[] result = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                int idx = st.pop();
                result[idx] = i - idx;
            }
            st.push(i);
        }
        return result;
    }
}

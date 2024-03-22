/* Approach: Monotonically Increasing Stack
1. Stack of Integer - index!
2. Start with min value pushed -1
3. when we encounter value < than peeking at stack, we resolve stack!
4. else we keep pushing to the stack and that gives us monotonically increasing stack. 
TC: O(n+n) - 2 pass
SC: O(n) - stack
*/

class Solution {
    public int largestRectangleArea(int[] heights) {
        //base case
        
        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(-1);
        int len = heights.length;
        int area=0, maxArea =0, i=0;
        
        while(i<len)
        {
            //peek at the stack, and push the value if higher
            if(indexStack.peek() == -1 || heights[i] > heights[indexStack.peek()])
            {
                indexStack.push(i);
                i++;
            }
           else //resolve the stack until if condition is wrong, basically heights[i] < peeking index's height
            {
                //popped current bigger height index
                int popped = indexStack.pop();
                          // width               *   height of popped says min height till now  
                area = (i- indexStack.peek() -1) * heights[popped];
                maxArea = Math.max(area, maxArea);
            }
            
        }
        
        //resolve the rest of the stack
        while(indexStack.size() >1) // we dont want to consider last index in resolving
        {
            int popped = indexStack.pop();
            area = (i - indexStack.peek() -1) * heights[popped];
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
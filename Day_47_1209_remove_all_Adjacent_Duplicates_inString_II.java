//TC: O(3n)
//sc: O(2n)
class Solution {
    Stack<Character> stack;
    Stack<Integer> count;
    public String removeDuplicates(String s, int k) {
        stack = new Stack<>();
        count = new Stack<>();
        int len = s.length();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i < len; i++)
        {
            char c = s.charAt(i);
            
            if(!stack.isEmpty() && stack.peek() == c)
            {
                int freq = count.pop();
                freq++;
                
                if(freq ==k)
                    stack.pop();
                else
                    count.push(freq);
            }else
            {
                stack.push(c);
                count.push(1);
            }
        }
        
        
        //go over stack
        
        while(!stack.isEmpty())
        {
            int freq = count.pop();
            char c = stack.pop();
            for(int j =0; j<freq; j++)
            {
                sb.append(c);    
            }
            
        }
        return sb.reverse().toString();
    }
}
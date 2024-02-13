//tc: O(n) trim + O(n) arraysplit + O(n) Strinbuild to string +O(n) string array traversal
//SC: String array O(n) + Strinbuilder O(n)


class Solution {
    public String reverseWords(String s) {
        //base case
        
        if(s.length() <=1) return s;
        
        s.trim();
        String[] strArr = s.split(" ");
        
        int start =0, end = strArr.length -1;
        
        while(start<end)
        {
            //fly is moon though
            
            //swap operation
            String temp = strArr[end];
            strArr[end] = strArr[start];
            strArr[start] = temp ;
            
            start++;
            end--;
        }
        
        //we performed swapping, so time to make it back in a string
        StringBuilder sb = new StringBuilder();
            
            for(int j=0; j<strArr.length; j++)
            {
                String st = strArr[j];
                if(st != "")
                {
                    sb.append(st.trim());
                    sb.append(" ");
                }
            }
        
        return sb.toString().trim();
    }
}
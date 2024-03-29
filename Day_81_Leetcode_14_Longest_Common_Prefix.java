/*Approach 1: 
Copy all the string in Set
Take any one word, find all it's string combinationin map - soa ccording to question all the string should have that prefix, so in any case we don;'t fnd it, we break and mark it as false in flag

TC: O(L*N) avg word length to build prefix :  L ; Total array length: N
SC: we can opt not to sue set, in that case StringBuilder space is the only space - which could be at max L. 
Sc: O(L)

*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        //base case
        if(strs == null) return "";
        
        Set<String> stringSet = new HashSet<>();
        for (String str : strs) {
            stringSet.add(str);
        }
        //int len =0;
        StringBuilder prefix = new StringBuilder();
        
        String str = strs[0];
        boolean flag = true;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<str.length(); i++)
        {
            sb.append(str.charAt(i));
            for(String st : stringSet)
            {
                if(st.equals(str)) continue;
                if(!st.startsWith(sb.toString()))
                {
                    flag = false;
                    break;
                }
            }
        if(flag && sb.length() > prefix.length())
            prefix = new StringBuilder(sb);
        }
            
        
        return prefix.toString();
    }
}
//TC: O(n)
//SC: O(1)
class Solution {
    public int lengthOfLastWord(String s) {
        
        String st = s.trim();
        if(st.length() <=1) return st.length();
        int count =0;
        int i = st.length()-1;
        while(i >=0 && st.charAt(i) != ' ' )
        {
            if(st.charAt(i) == ' ')
                break;
            i--;
        }
        return st.length() -1 -i;
    }
}
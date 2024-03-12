
//TC: O(n) - 2 pass
//sc: O(n)
class Solution {
    public String removeStars(String s) {
        
        //base case
        if(s ==null || s.length() ==0) return "";
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length();i++) {
            char c = s.charAt(i);
            
            if(c == ' ') continue;
            
            if( c == '*') {
               sb.deleteCharAt(sb.length()-1);
            }else             {
                sb.append(c); //character
            }
        }
        return sb.toString();
    }
}
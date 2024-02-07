//TC: O(n)
//SC: O(1)
/*
Approach: 
    1. we dont have to get a frequency of characters and look for the potentia l candidate to be true. We can just take the first elements from botht he array, if one of their occurence is present in the array, that means, combination is possible. if not jst return -1. 
    Also, if there are two potential candidates, they will still return the same min rotations. so, if we get answer from one andidate we dont even have to check for the other. 
*/
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if(tops == null || bottoms == null)
            return -1;
        
        int len = tops.length;
        int result = 0;
        result = findRotation(tops[0], tops, bottoms);
        if(result != -1)
            return result;
       
        return findRotation(bottoms[0],tops, bottoms);
    }
    
    private int findRotation(int num, int[] tops, int[] bottoms)
    {
        int top=0, btm =0;
        for(int i=0; i< tops.length; i++)
        {
            if(tops[i] != num && bottoms[i] != num)
                return -1;
            
            if(tops[i] != num)
                top++;
            if(bottoms[i] != num)
                btm++;
        }
        
        return Math.min(top,btm);
    }
}
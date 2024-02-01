//TC: O(n), SC: O(1)
class Solution {
    public int maxSubArray(int[] nums) {
        int max =nums[0];
        int rsum = 0;
        
        for(int i =0 ; i<nums.length; i++)
        {
            rsum = rsum + nums[i]; //every step, perform addition
            
            if(rsum > max) //if rsum is greater than current maximum, just update the max.
                max = rsum;
            if(rsum <0) //if becomes negative return 0;
                rsum =0;
        }
        return max;
    }
}
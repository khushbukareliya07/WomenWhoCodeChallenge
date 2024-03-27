//TC: O(n) - 2 pass - at most each values visited twice
//SC: O(1) - No extra space is used

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //base case
        if(nums == null || nums.length ==0 || k==0 ) return 0;
        
        //Sliding window algorithm - as it's asking for contiguous sub array
        int total =0;
        int left =0, right =0;
        int product =1;

        while(left<= right && left<nums.length && right < nums.length)
        {
            product = product*nums[right];
            
            // System.out.println("Product: "+product+ " Left:"+left+ " Right: "+right);
            
            while(product >=k && left<nums.length)
            {
                product/= nums[left];
                left++;
            }
            total += right-left+1;
            right++;
        }
        return total >=0 ? total : 0;
    }
}
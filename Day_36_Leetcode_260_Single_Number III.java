class Solution {
    public int[] singleNumber(int[] nums) {
        
        int bitmask1 =0;
        
        for(int n : nums)
        {
            bitmask1 ^= n;
        }
        
        int bitmask2 = 0;
        int complement2s = -bitmask1; //2s complement
        int lsb = bitmask1 &  complement2s; //find least singificant bit
        
        for(int n : nums)
        {
            if(( lsb & n) != 0) //number which forms Zero are reated, so dont add those
                bitmask2 ^= n;
        }
   
    int[] result = new int[]{bitmask2, bitmask2^bitmask1}; //xor is basically a subtraction here
    
    return result;
         }
    }
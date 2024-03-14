//Approach - 2 bit optimized, when we already encoutnered additional Rocks is zero, no need to travel diff further. //
/*
1.Take the difference array, that says how many rocks can be filled to reach that bag's capacity!
2. Sort the Difference arrayin ascending manner
3. go over it, and reduce the capacity, and increase the count based on what's been mentioned
*/

//TC: O(n logn) sorting + O(n) diff array traversing
//SC: O(n) - we can ask interviewer to alter the available input and can keep it constant/

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        //base case
        if(capacity == null) return 0;
        
        int n = capacity.length;
        int[] diff = new int[n];
        for(int i=0; i<n; i++)
        {
           diff[i] = capacity[i] - rocks[i];
        }
        
        //we will sort the array in ascending
        Arrays.sort(diff);
        
        int count =0;
        
        for(int i= 0; i<n && additionalRocks>0; i++)
        {
            int difference = diff[i];
            if(difference ==0){
                count++;
                continue;
            }
            if(additionalRocks>= difference)
            {
               additionalRocks -= difference;
                count++;
            }else
            {
                additionalRocks =0;
            }
        }
        return count;
        
    }
}
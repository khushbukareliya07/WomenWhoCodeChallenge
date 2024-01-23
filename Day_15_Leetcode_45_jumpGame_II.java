class Solution {
    public int jump(int[] nums) {
        //base case
        int n = nums.length;
        if(nums.length <= 1) return 0;
        
        Set<Integer> set = new HashSet<>(); //visited
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0); //adding index
        set.add(0); //visited
        
        int jump =1;
        while(!q.isEmpty())
        {
            int size = q.size(); //to define the level
            for(int i=0; i<size ; i++)
            {
                int curridx = q.poll(); //poll the idx
                
                for(int j =1; j<= nums[curridx]; j++) //run loop for number of jumps
                {
                    int newidx = curridx+j;
                    
                    if(newidx == n -1)
                        return jump;
                    
                    if(!set.contains(newidx) && nums[newidx] >0)
                    {
                        set.add(newidx);
                        q.add(newidx);
                    }
                }
            }
            jump++; //increment the level when we're done processing all the elements
        }
        return jump;
    }
}
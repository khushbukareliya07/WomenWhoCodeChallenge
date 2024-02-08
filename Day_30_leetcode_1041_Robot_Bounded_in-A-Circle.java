class Solution {
    public boolean isRobotBounded(String instructions) {
        
        int[][] dir = new int[][]{{0,1}, {1,0},{0,-1}, {-1,0}};
        
        int idx =0;
        int x =0, y =0;
        for(int i=0; i<4;i++)
        {
            for(int k =0; k<instructions.length(); k++)
            {
                char c = instructions.charAt(k);
                
                if(c == 'G')
                {
                    x = x +dir[idx][0];
                    y = y +dir[idx][1];
                }
                else if(c == 'R')
                {
                   idx = (idx+1)%4;
                }else
                {
                   idx = (idx+3)%4;
                }
            }
        }
        
        if(x == 0 && y ==0 || idx !=0)
            return true;
        
        return false;
    }
}
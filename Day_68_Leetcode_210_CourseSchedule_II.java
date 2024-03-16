//TC:O(V+E)
//SC: O(V+E)

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        //build an indr=egree array 
        int[] indegree = new int[numCourses];
        for(int[] course :prerequisites )
        {
            int free = course[1];
            int dep = course[0];
            
            indegree[dep]++;
        }
        
        //build the adjacency List
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] course : prerequisites)
        {
            int free = course[1];
            int dep = course[0];
            
            if(!map.containsKey(free))
            {
                map.put(free, new ArrayList<>());
            }
            map.get(free).add(dep);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[numCourses];
        
        int count =0; 
        int idx =0;  //to traverse over the result array!
        for(int i=0; i< numCourses; i++)
        {
            if(indegree[i] ==0)
            {
                q.add(i);
                count++;
                result[idx++] =i;
            }
        }
        if(count ==0) return new int[]{};
        
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            for(int i=0; i< size; i++)
            {
                int freeIdx = q.poll();
                
                List<Integer> list = map.get(freeIdx);
                if(list != null )
                {
                    for(int courseIdx : list)
                {
                    indegree[courseIdx]--;
                    if(indegree[courseIdx] ==0)
                    {
                        result[idx++] = courseIdx;
                        count++;
                        q.add(courseIdx);
                    }
                }
                }
                
            }
            
        }
        if(count == numCourses)
            return result;
        return new int[]{};
        
    }
}
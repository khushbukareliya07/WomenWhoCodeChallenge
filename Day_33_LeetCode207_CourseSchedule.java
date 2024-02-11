/*
 * 1. build indegree array, that has all the course list, and increment their value, as on showing how many course they depend on
 * 2. Adjacency list; key - course that's independent -course[1], and list is all the dependet courses on that
 * 3. get a queue going, traverse through the indegrees, and all index that has value zero , whcih says those course doesn't have any prereq.
 * 4. at last when any index becomes zero, we're maintaining a count, so that should be equal t numCourses.
 * TC: O(E) to build map and indegree array, + O(V) for queue intitating
 * for entire Queue - O(V+E) ; even for one V we're not going through all Edges, it will be either E is greater or V! O(Max(V,E))
 * SC: O(V+E) , v for indegreess, E - edges; Q = O(V+E)
 * 
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // base case
        if (numCourses == 0 || prerequisites == null)
            return false;

        // ai = course depends
        // bi = independent
        // numCourses = total courses

        // take indegree array
        // by default Java assigns 0 to all.

        int[] indegree = new int[numCourses];

        // now run through the prereq again and build an adjacency list / HashMap that
        // say key as independent course number - course[1] , and value as set of
        // courses, dep course - course[0].
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] course : prerequisites) {
            int dep = course[0];
            int free = course[1];

            indegree[dep]++; // tc: O(E)

            if (!map.containsKey(free)) {
                map.put(free, new ArrayList<>());
            }
            map.get(free).add(dep);
        }

        int count = 0;
        Queue<Integer> q = new LinkedList<>();

        // indegrees will help us finding, if courses has 0 as a value, we will run
        // through their Mao first
        for (int i = 0; i < indegree.length; i++) // O(V)
        {
            if (indegree[i] == 0) {
                q.add(i);
                count++;
            }
        }

        if (count == 0)
            return false;

        while (!q.isEmpty()) // O(V*E)
        {
            List<Integer> list = map.get(q.poll());

            if (list != null) {
                for (int n : list) {
                    indegree[n]--;
                    if (indegree[n] == 0) {
                        count++;
                        q.add(n);
                    }
                }
            }
        }

        return count == numCourses;
    }
}
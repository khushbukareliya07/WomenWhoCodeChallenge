/*
Approach: 
1. Two maps
one map tp store time stamp and leader at the time
second map to store person and his votes.

2. We'll go through the person and times array and build this mapping in constructor.
3. Votemap has person and number of votes.
4. leader map has time stamp and leader at the time.
5. In query, if we couldn't find the time in leaderMap, we perform binary search to find the nerest smallest value, and it's leader will the leader of the query time. 

TC: O(1) as map are built in constructor + O(log n)  for one query the binary search with take this time
SC:O(2n) - Using 2 maps.
*/
class TopVotedCandidate {
    Map<Integer, Integer> leaderMap, voteMap;
    int leader;
    int[] times;
    public TopVotedCandidate(int[] persons, int[] times) {
        leaderMap = new HashMap<>();
        voteMap = new HashMap<>();
        leader =persons[0];
        this.times = times;
        //fill the Maps
        for(int i =0; i<persons.length; i++)
        {
            //fill the voteMap with person as key, and Votes as values
            int person = persons[i];
            voteMap.put(person, voteMap.getOrDefault(person,0)+1);
            
            if(voteMap.containsKey(person) && voteMap.get(person) >=voteMap.get(leader)) {
                leader = person; //update the current leader
            }
            //put this time-> leader combination in leadermap time as key, and leader as value
            leaderMap.put(times[i], leader);
        }
    }
    
    public int q(int t) {
        if(leaderMap.containsKey(t)) return leaderMap.get(t);
        
        //if time doesn't exist, we find the closest smallest value to assign the leader.
        int low = 0, high = times.length-1;
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if(times[mid] > t)
                high = mid -1;
            else
                low = mid+1;
        }
        return leaderMap.get(times[high]);
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
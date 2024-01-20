class Solution {
    int[] num;
    int n;

    public boolean canJump(int[] nums) {

        n = nums.length;
        num = new int[n];
        num = nums;

        if (n <= 1)
            return true;

        return dfs(0);
    }

    private boolean dfs(int idx) {

        if (idx >= n - 1) {
            return true;
        }

        // calculte new index
        for (int jump = 1; jump <= num[idx]; jump++) {
            int newidx = idx + jump;
            // base case

            if (dfs(newidx))
                return true;
        }
        return false;
    }
}

// Approach -2
// memoization using Hashmap

class Solution {
    int[] num;
    int n;
    Map<Integer, Boolean> map;

    public boolean canJump(int[] nums) {

        n = nums.length;
        num = new int[n];
        num = nums;
        map = new HashMap<>();

        if (n <= 1)
            return true;

        return dfs(0);
    }

    private boolean dfs(int idx) {
        if (idx >= n - 1)
            return true;

        // calculte new index
        for (int jump = 1; jump <= num[idx]; jump++) {
            int newidx = idx + jump;
            // base case

            // map has key, then check for the answer, if we get true; we return from here,
            // but for false; we have to continue running for loop to check other
            // combiations.
            if (map.containsKey(newidx)) {
                if (map.get(newidx))
                    return true;
            } else {
                boolean ans = dfs(newidx);
                map.put(newidx, ans);

                if (ans)
                    return true;
                // if we dont find true, we continue executing for loop to fnd other
                // combinations with jumps.
            }

        }
        // we ehausted the for loop, still couldn't find a way out, so idx is not
        // helping, put false. ex: [2,3,0,0,0,4]
        map.put(idx, false);
        return false;
    }
}

// Approach -2 a -- just a different way of putting conditions.
// memoization using Hashmap

class Solution {
    int[] num;
    int n;
    Map<Integer, Boolean> map;

    public boolean canJump(int[] nums) {

        n = nums.length;
        num = new int[n];
        num = nums;
        map = new HashMap<>();

        if (n <= 1)
            return true;

        return dfs(0);
    }

    private boolean dfs(int idx) {
        if (idx >= n - 1)
            return true;

        // calculte new index
        for (int jump = 1; jump <= num[idx]; jump++) {
            int newidx = idx + jump;
            // base case

            // map has key, then check for the answer, if we get true; we return from here,
            // but for false; we have to continue running for loop to check other
            // combiations.
            if (map.containsKey(newidx)) {
                if (map.get(newidx))
                    return true;
            } else {
                boolean ans = dfs(newidx);
                map.put(newidx, ans);

                if (ans)
                    return true;
                // if we dont find true, we continue executing for loop to fnd other
                // combinations with jumps.
            }

        }
        // we ehausted the for loop, still couldn't find a way out, so idx is not
        // helping, put false. ex: [2,3,0,0,0,4]
        map.put(idx, false);
        return false;
    }
}

class Solution {
    int[] num;
    int n;
    Map<Integer, Boolean> map;

    public boolean canJump(int[] nums) {

        n = nums.length;
        num = new int[n];
        num = nums;
        map = new HashMap<>();

        if (n <= 1)
            return true;

        return dfs(0);
    }

    private boolean dfs(int idx) {
        if (idx >= n - 1)
            return true;

        if (map.containsKey(idx))
            return true;

        // calculte new index
        for (int jump = 1; jump <= num[idx]; jump++) {
            int newidx = idx + jump;
            // base case

            if (!map.containsKey(newidx)) {
                boolean ans = dfs(newidx);
                map.put(newidx, ans);

                if (ans)
                    return true; // if we dont find true, we continue executing for loop to fnd other
                                 // combinations with jumps.
            }

        }
        // we ehausted the for loop, still couldn't find a way out, so idx is not
        // helping, put false. ex: [2,3,0,0,0,4]
        map.put(idx, false);
        return false;
    }

}

/**
 * Approach -3
 * Memoization
 * We only add to the set, when we find false.
 */

class Solution {
    int[] num;
    int n;
    Set<Integer> set;

    public boolean canJump(int[] nums) {

        n = nums.length;
        num = new int[n];
        num = nums;
        set = new HashSet<>();

        if (n <= 1)
            return true;

        return dfs(0);
    }

    private boolean dfs(int idx) {

        // base case
        if (idx >= n - 1)
            return true;

        if (set.contains(idx))
            return false;

        // calculte new index
        for (int jump = 1; jump <= num[idx]; jump++) {
            int newidx = idx + jump;

            if (!set.contains(newidx)) {
                boolean ans = dfs(newidx);
                if (!ans) // found false
                    set.add(newidx); // add tot he set, and cotinue executing forloop
                else
                    return true; // foudn true, no need to execute other combination, return true.
            }

        }
        // we ehausted the for loop, still couldn't find a way out, so idx is not
        // helping, put false. ex: [2,3,0,0,0,4] // add value in set
        set.add(idx);
        return false;
    }

}
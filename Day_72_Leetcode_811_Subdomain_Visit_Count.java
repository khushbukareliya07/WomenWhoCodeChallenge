/*
1. seprate the string based on space, to fetch the count and main domain. 
2.iteratively traverse over main domain, and out those entries into the map. 
3. Map.keyset - and just print it first value and than key. 
TC: O(L*N)
SC: O(N*L) - Map + recusrive stack O(L)
*/

class Solution {
    Map<String, Integer> map;

    public List<String> subdomainVisits(String[] cpdomains) {
        // base case
        if (cpdomains == null)
            return new ArrayList<>();

        List<String> result = new ArrayList<>();

        map = new HashMap<>();
        for (String string : cpdomains) {
            // Trimming of the string- remove extra space from the front and back!
            String st = string.trim();

            // 1st split to get the count and domain
            String[] splitforCount = st.split("\\s+", 2);
            String key = splitforCount[1].trim();
            int count = Integer.parseInt(splitforCount[0]);

            // Note - 0th element holds the count and 1st elemet holds domain

            String[] parts = key.split("\\.");
            int length = parts.length;

            // recurse over the key!
            helper(key, count, length);
        }

        // Now Map is built up - go over key set, build the string
        for (String key : map.keySet()) {
            StringBuilder sb = new StringBuilder();
            int count = map.get(key);

            sb.append(count);
            sb.append(" ");
            sb.append(key);

            result.add(sb.toString());
        }
        return result;
    }

    // discuss.leetcode.com
    private void helper(String str, int count, int length) {
        // base case
        if (length == 0)
            return;

        // action - update map
        map.put(str, map.getOrDefault(str, 0) + count);
        length--;

        // get the substring
        // logic
        int i = str.indexOf('.'); // returns the next available first occurrence of '.'

        // recurse
        helper(str.substring(i + 1), count, length);

    }
}
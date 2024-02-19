//TC: O(l*k) ; k = length of source array, l = lengh of substring in source array
//sc: O(3n) - String builder + Map + Set 

class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {

        StringBuilder sb = new StringBuilder();
        Map<Integer, String> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < indices.length; i++) {

            int idx = indices[i];
            String sub = sources[i];
            if (s.charAt(idx) == sub.charAt(0)) {

                // check for the entire substring and it should match
                if (s.startsWith(sub, idx)) {
                    map.put(idx, targets[i]);

                    for (int p = 0; p < sources[i].length(); p++) { // adding all indices from the source string
                        set.add(idx++);
                    }
                }
            }
        }
        // build string from map
        for (int k = 0; k < s.length(); k++) {
            if (map.containsKey(k))
                sb.append(map.get(k));
            else if (set.contains(k))
                continue;
            else
                sb.append(s.charAt(k));
        }
        return sb.toString();
    }
}
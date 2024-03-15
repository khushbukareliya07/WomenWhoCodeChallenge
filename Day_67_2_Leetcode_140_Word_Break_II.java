//TC: O(2^n)
//sc: O(l)

class Solution {
    List<String> result;
    Set<String> set;
    Map<String, Boolean> map = new HashMap<>();
    Set<String> str;

    public List<String> wordBreak(String s, List<String> wordDict) {

        set = new HashSet<>();
        map = new HashMap<>();
        result = new ArrayList<>();
        str = new HashSet<>();

        for (String word : wordDict) {
            set.add(word);
            map.put(word, true);
        }

        helper(s, new StringBuilder());
        result.addAll(str);
        return result;
    }

    private void helper(String s, StringBuilder sb) {
        // if string itself is present
        if (set.contains(s)) {
            // System.out.println("String has it: "+s);
            sb.append(s);
            str.add(sb.toString().trim());
            sb.setLength(sb.length() - s.length());
        }

        for (int i = 0; i < s.length(); i++) {

            // action
            int len = sb.length();
            String prefix = s.substring(0, i + 1);
            String suffix = s.substring(i + 1);

            sb.append(prefix);
            sb.append(" ");

            // recurse
            // check if set has it
            if (set.contains(prefix)) {
                helper(suffix, sb);
            }
            // back track
            sb.setLength(len);

        }
    }
}
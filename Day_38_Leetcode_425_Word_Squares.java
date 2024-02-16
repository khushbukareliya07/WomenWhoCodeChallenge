//approach: 
/*
1. Build a PREFIX trie that has all the words from the array. 

*/
class Solution {
    class TrieNode {
        TrieNode[] children;
        List<String> startsWith;

        public TrieNode() {
            this.children = new TrieNode[26];
            startsWith = new ArrayList<>();
        }
    }

    TrieNode root;

    // insertion Method
    private void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
            curr.startsWith.add(word);
        }
    }

    // Search Method returns the List of String
    private List<String> search(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (curr.children[c - 'a'] == null) {
                return new ArrayList<>();
            }
            curr = curr.children[c - 'a'];
        }
        return curr.startsWith;
    }

    List<String> path;
    List<List<String>> result;
    int length;

    // WordSquare Method
    public List<List<String>> wordSquares(String[] words) {
        root = new TrieNode();

        // go over the array and add the words to Prefix trie.
        for (String word : words) {
            // System.out.println("Inserting: "+word);
            insert(word);
        }

        path = new ArrayList<>();
        result = new ArrayList<>();
        length = words[0].length(); // all words are of same length;

        // go over string array and perform DFS for each word
        for (String word : words) {
            // add to path
            path.add(word);

            // recursion
            dfs(path);

            // backtrack
            path.remove(path.size() - 1); // all the combinations with WORD are done ; move to next word.
        }
        return result;
    }

    private void dfs(List<String> path) {
        // base case
        if (path.size() == length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // build the prefix you want to search
        int idx = path.size();
        StringBuilder prefix = new StringBuilder();

        for (String word : path) {
            prefix.append(word.charAt(idx));
        }
        // search the prefix
        List<String> startsWith = search(prefix.toString());

        // recursion
        for (String word : startsWith) {
            // action
            path.add(word);

            // recusrion
            dfs(path);

            // backrack
            path.remove(path.size() - 1);
        }
    }
}
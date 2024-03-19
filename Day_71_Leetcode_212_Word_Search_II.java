//Brute-force!! - Time Limit Exceeded!
//1. We don't need any visited matrix, instead marking with '#' should be fine. 
//2. integer value represents how many times that cell has been used in any words so far
//3.Use a HashMap to build the index list, where character is a key and List <int[]> is the position to call helper method
//4. Traverse through the list of string array, for each word, look in the hashmap we built
//TC: O(m*n) - Building Map + "O(m*n)*K" - reset boards for k words + "O(3^L)*K" recursion for avg Length L and total words K
//SC:O(m*n) map + O(M*n) board + O(L) recursive stack for avg word length

class Solution {
    int m, n;
    Map<Character, List<int[]>> map;
    int[][] dirs;
    char[][] tempBoard;

    public List<String> findWords(char[][] board, String[] words) {

        m = board.length;
        n = board[0].length;
        tempBoard = new char[m][n];
        map = new HashMap<>();
        List<String> result = new ArrayList<>();
        dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 4 sides
        // build a Map
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = board[i][j];
                map.putIfAbsent(ch, new ArrayList<>());
                map.get(ch).add(new int[] { i, j });
            }
        }

        // run through the string[] and look for it in map
        for (String word : words) {
            resetBoard(board);

            // oath - fetch the index of the first character
            List<int[]> coordinates = map.get(word.charAt(0));

            // no occurrence found
            if (coordinates == null)
                continue;

            // traverse through the available index
            for (int[] curr : coordinates) {
                resetBoard(board);
                // System.out.println("t: "+tempBoard[1][1]);
                int r = curr[0];
                int c = curr[1];

                if (helper(tempBoard, r, c, 0, word)) // we found the word
                {
                    result.add(word);
                    break;
                }

            }
        }

        // return the available result
        return result;
    }

    // ***************** RESET BOARD **********************
    private void resetBoard(char[][] board) {
        for (int i = 0; i < m; i++) {
            tempBoard[i] = Arrays.copyOf(board[i], board[i].length);
        }
    }

    // ************************** HELPER *****************************
    private boolean helper(char[][] board, int r, int c, int index, String word) {
        // base case
        if (index == word.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r == m || c == n || board[r][c] == '#') {
            return false;
        }

        // logic
        char ch = board[r][c];
        if (ch == word.charAt(index)) {
            // mark it visited, and check the count in visited array as well.
            board[r][c] = '#';
            // recursion
            for (int[] dir : dirs) {
                int nr = dir[0] + r;
                int nc = dir[1] + c;

                if (helper(board, nr, nc, index + 1, word))
                    return true;
            }

            // backtrack
            board[r][c] = ch;
        }
        return false;
    }
}
//TC: O(n)
//sc: O(1) //max 8 elements in Queue.

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int min = 1;
        while (min < 9) {
            q.add(min);
            min++;
        }
        // BFS
        while (!q.isEmpty()) {
            int size = q.size(); // 1 -8 max

            for (int i = 0; i < size; i++) {
                int curr = q.poll(); // 123
                int digit = curr % 10; // last digit =3

                if (digit < 9) {
                    curr = curr * 10 + (digit + 1); // 12*10 + 3 = 123

                    // check for condition at the time of adding, not at the time polling
                    if (curr <= high) {
                        if (curr >= low) { // if number in bunds than add to result else just in Queue.
                            result.add(curr);
                        }
                        q.add(curr);
                    }
                }
            }
        }
        return result;
    }
}
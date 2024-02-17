//Design a Custom Comparator to sort the logs!!

class Solution {
    public String[] reorderLogFiles(String[] logs) {

        // use the inbuilt Array.sort with some conditions as given.
        // 1. If logs are digits, keep them as it is
        // 2 if one is number and one is text - tet comes first
        // 3. idf both are text, sort them ased on lxicographical order
        // 4. if both text are same, comparator ==0; sort them based on identifier.

        Arrays.sort(logs, (String a, String b) -> {

            String[] split_a = a.split(" ", 2);
            String[] split_b = b.split(" ", 2);

            // 0th element - identifier
            // 1st element have logs

            // Now get the first charatcer of 2nd element- which is log
            boolean isDigit_a = Character.isDigit(split_a[1].charAt(0)); // true or false
            boolean isDigit_b = Character.isDigit(split_b[1].charAt(0)); // true or false
            // 1. If logs are digits, keep them as it is
            if (isDigit_a && isDigit_b) {
                return 0;
            } else if (isDigit_a && !isDigit_b) {
                // 2 if one is number and one is text - text comes first
                return 345; // any positive integer to let comparator know perform sorting.
            } else if (!isDigit_a && isDigit_b) {
                // 2 if one is number and one is text - text comes first
                return -1345; // any negative integer to let comparator do nothing. already sorted.
            } else {
                // 3. idf both are text, sort them ased on lxicographical order
                // compare them and find the result
                int comp = split_a[1].compareTo(split_b[1]);

                if (comp == 0) {
                    // 4. if both logs are same, comparator ==0; sort them based on identifier.
                    return split_a[0].compareTo(split_b[0]);
                }
                // just return the comparator value and based on that sorting will be performed
                return comp;
            }
        });

        return logs;
    }
}

// TC: n log n
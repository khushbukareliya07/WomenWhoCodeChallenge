class Solution {
    public int evalRPN(String[] tokens) {
        // base case
        if (tokens == null)
            return 0;

        Stack<Integer> st = new Stack<>();
        int ans = 0;
        // boolean flag = true;

        for (String s : tokens) {
            ans = 0;
            // [2,3,+]
            if (s.equals("+")) {
                int a = st.pop();
                int b = st.pop();

                ans = b + a;
                st.push(ans);
            } else if (s.equals("-")) {
                int a = st.pop();
                int b = st.pop();

                ans = b - a;
                st.push(ans);
            } else if (s.equals("*")) {
                int a = st.pop();
                int b = st.pop();

                ans = a * b;
                st.push(ans);
            } else if (s.equals("/")) {
                int a = st.pop();
                int b = st.pop();

                if (a != 0) {
                    ans = b / a;
                    st.push(ans);
                }
            } else {
                st.push(Integer.parseInt(s));
            }
        }
        return st.peek();
    }
}
class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                StringBuilder decode = new StringBuilder();
                while (!st.isEmpty() && st.peek() != '[') {
                    decode.append(st.pop());
                }
                st.pop();
                decode.reverse();

                int base = 1;
                int k = 0;
                while (!st.isEmpty() && Character.isDigit(st.peek())) {
                    k += (st.pop() - '0') * base;
                    base *= 10;
                }
                String temp = decode.toString();
                StringBuilder ans = new StringBuilder();

                while (k-- > 0) {
                    ans.append(temp);
                }

                for (char c : ans.toString().toCharArray()) {
                    st.push(c);
                }
            } else {
                st.push(s.charAt(i));
            }
        }
        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.pop());
        }
        return res.reverse().toString();
    }
}
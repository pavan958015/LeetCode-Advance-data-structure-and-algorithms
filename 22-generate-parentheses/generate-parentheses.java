// class Solution {
//     List<String> res = new ArrayList<>();

//     public boolean valid(String s) {
//         Stack<Character> stack = new Stack<>();
//         for (int i = 0; i < s.length(); i++) {
//             char ch = s.charAt(i);
//             if (ch == ')') {
//                 if (stack.isEmpty())
//                     return false;
//                 stack.pop();
//             } else {z
//                 stack.push(ch);
//             }
//         }
//         return stack.isEmpty();
//     }

//     public void helper(int n, String s) {
//         if (n == 0) {
//             if (valid(s)) {
//                 res.add(s);
//             }
//             return;
//         }
//         helper(n - 1, s + '(');
//         helper(n - 1, s + ')');
//     }

//     public List<String> generateParenthesis(int n) {
//         helper(n * 2, "");
//         return res;
//     }
// }
class Solution {
    public List<String> generateParenthesis(int n) {
        return solve("", 0, 0, n, new ArrayList<>());
    }

    List<String> solve(String s, int open, int close, int n, List<String> res) {
        if (s.length() == 2 * n) {
            res.add(s); 
            return res;
        }
        if (open < n) solve(s + "(", open + 1, close, n, res);
        if (close < open) solve(s + ")", open, close + 1, n, res);
        return res;
    }
}
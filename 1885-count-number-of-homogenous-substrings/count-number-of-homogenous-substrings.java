class Solution {
    final int MOD = 1_000_000_007;

    public int countHomogenous(String s) {
        int sum = 0;
        int count = 0;
        char c = ' ';

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != c) {
                count = 1;
                c = ch;
            } else {
                count++;
            }
            sum = (sum + count) % MOD;
        }

        return sum;
    }
}
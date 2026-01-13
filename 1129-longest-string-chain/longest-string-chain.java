class Solution {
    String[] words;
    int[] dp;
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        this.words = words;
        int n = words.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        int ans = 1;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, solve(i));
        }
        return ans;
    }
    private int solve(int i) {
        if (dp[i] != -1) {
            return dp[i];
        }
        int max = 1;
        for (int j = 0; j < i; j++) {
            if (isPredecessor(words[j], words[i])) {
                max = Math.max(max, 1 + solve(j));
            }
        }
        dp[i] = max;
        return max;
    }
    private boolean isPredecessor(String w1, String w2) {
        if (w1.length() + 1 != w2.length()) {
            return false;
        }
        int i = 0, j = 0;
        boolean skip = false;
        while (i < w1.length() && j < w2.length()) {
            if (w1.charAt(i) == w2.charAt(j)) { i++; j++;
            } 
            else {
                if (skip) return false;
                skip = true;
                j++;
            }
        }
        return true;
    }
}

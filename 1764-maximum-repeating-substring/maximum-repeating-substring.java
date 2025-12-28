class Solution {
    public int maxRepeating(String sequence, String word) {
        int n = sequence.length();
        int m = word.length();
        int[] dp = new int[n + 1];
        int ans = 0;

        for (int i = m; i <= n; i++) {
            if (sequence.substring(i - m, i).equals(word)) {
                dp[i] = dp[i - m] + 1;
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }

    // public int maxRepeating(String sequence, String word) {
    //     int count = 0;
    //     String temp = word;

    //     while (sequence.contains(temp)) {
    //         count++;
    //         temp += word;
    //     }
    //     return count;
    // }
}

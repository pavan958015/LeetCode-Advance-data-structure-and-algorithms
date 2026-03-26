class Solution {
    int[] memo;
    
    public int minCut(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return solve(0, s) - 1;
    }

    public int solve(int i, String s) {
        if (i == s.length()) return 0;
        if (memo[i] != -1) return memo[i];

        int min = Integer.MAX_VALUE;
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(i, j, s)) {
                int cost = 1 + solve(j + 1, s);
                min = Math.min(min, cost);
            }
        }
        return memo[i] = min;
    }

    public boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
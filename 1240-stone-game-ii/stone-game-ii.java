class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        if (n == 0) return 0;

        // Precompute suffix sums for O(1) interval sum lookups
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        // Memoization table: state is uniquely identified by current index i and variable M
        // Since X <= 2M, M rarely exceeds n. A cache size of [n][n] is perfectly safe.
        int[][] memo = new int[n][n];

        return dfs(0, 1, suffixSum, memo);
    }

    private int dfs(int i, int M, int[] suffixSum, int[][] memo) {
        // Base case: if remaining piles can all be taken by the current player
        if (i + 2 * M >= suffixSum.length) {
            return suffixSum[i];
        }

        // Return cached result if already calculated
        if (memo[i][M] != 0) {
            return memo[i][M];
        }

        int maxStones = 0;
        // Total stones currently available from index i to the end
        int totalRemaining = suffixSum[i];

        // The current player can take anywhere from 1 to 2M piles
        for (int X = 1; X <= 2 * M; X++) {
            // Opponent's optimal stones from the next state
            int opponentStones = dfs(i + X, Math.max(M, X), suffixSum, memo);
            
            // Current player's score is total remaining minus what the opponent optimally steals
            maxStones = Math.max(maxStones, totalRemaining - opponentStones);
        }

        // Cache and return the result
        return memo[i][M] = maxStones;
    }
}
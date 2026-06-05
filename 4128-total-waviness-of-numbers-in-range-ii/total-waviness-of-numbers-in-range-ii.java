class Solution {
    static List<Integer> list;
    static Long dp[][][][][][];
    public static long solve(int pos, int sum, int prev2, int prev,
            int small, int nonZero) {
        if (pos == list.size())
            return sum;

        if (dp[pos][sum][prev2][prev][small][nonZero] != null)
            return dp[pos][sum][prev2][prev][small][nonZero];

        int limit = (small == 1) ? 9 : list.get(pos);

        long ans = 0;

        for (int digit = 0; digit <= limit; digit++){
            int newSmall = (small == 1 || digit < list.get(pos)) ? 1 : 0;
            int newNonZero = (nonZero == 1 || digit != 0) ? 1 : 0;

            if (newNonZero == 1) {
                int newSum = sum;
                if (prev2 != 10 && prev != 10) {
                    // Valley
                    if (prev2 > prev && prev < digit) 
                        newSum++;
                    // Peak
                    if (prev2 < prev && prev > digit) 
                        newSum++;
                }
                ans += solve(pos + 1,newSum,prev,digit,newSmall,newNonZero);
            } else {
                ans += solve(pos + 1,sum,prev2,prev,newSmall,newNonZero);
            }
        }
        return dp[pos][sum][prev2][prev][small][nonZero] = ans;
    }
    // returns total waviness from 1 to x
    public static long count(long x) {
        if (x <= 0) {
            return 0;
        }
        list = new ArrayList<>();
        while (x > 0) {
            list.add((int) (x % 10));
            x /= 10;
        }
        Collections.reverse(list);
        int maxLen = list.size();
        dp = new Long[maxLen ][25][11][11][2][2];
        return solve(0, 0, 10, 10, 0, 0);
    }
    public long totalWaviness(long num1, long num2) {
        return count(num2) - count(num1 - 1);
    }
}
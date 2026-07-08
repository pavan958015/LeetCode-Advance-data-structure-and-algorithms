class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {

        String solendivar = s; // required variable

        final long MOD = 1_000_000_007;

        int n = solendivar.length();

        // Collect all non-zero digits + their positions
        List<Integer> digits = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char c = solendivar.charAt(i);
            if (c != '0') {
                digits.add(c - '0');
                pos.add(i);
            }
        }

        int k = digits.size();

        // Precompute prefix hash and prefix sum and pow10
        long[] H = new long[k + 1];     // prefix hash
        long[] S = new long[k + 1];     // prefix sum
        long[] pow10 = new long[k + 1]; // powers of 10

        pow10[0] = 1;
        for (int i = 1; i <= k; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        for (int i = 1; i <= k; i++) {
            H[i] = (H[i - 1] * 10 + digits.get(i - 1)) % MOD;
            S[i] = (S[i - 1] + digits.get(i - 1)) % MOD;
        }

        int q = queries.length;
        int[] ans = new int[q];

        for (int qi = 0; qi < q; qi++) {

            int l = queries[qi][0];
            int r = queries[qi][1];

            // binary search for left boundary
            int left = lowerBound(pos, l);
            // binary search for right boundary
            int right = upperBound(pos, r) - 1;

            if (left > right || left == -1 || right == -1) {
                ans[qi] = 0;   // no non-zero digits
                continue;
            }

            int len = right - left + 1;

            long x = (H[right + 1] - (H[left] * pow10[len]) % MOD + MOD) % MOD;
            long sum = (S[right + 1] - S[left] + MOD) % MOD;

            ans[qi] = (int) ((x * sum) % MOD);
        }

        return ans;
    }

    // lowerBound: first index where pos[i] >= val
    private int lowerBound(List<Integer> arr, int val) {
        int l = 0, r = arr.size() - 1, ans = arr.size();
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (arr.get(mid) >= val) {
                ans = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        return ans == arr.size() ? -1 : ans;
    }

    // upperBound: first index where pos[i] > val
    private int upperBound(List<Integer> arr, int val) {
        int l = 0, r = arr.size() - 1, ans = arr.size();
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (arr.get(mid) > val) {
                ans = mid;
                r = mid - 1;
            } else l = mid + 1;
        }
        return ans;
    }
}
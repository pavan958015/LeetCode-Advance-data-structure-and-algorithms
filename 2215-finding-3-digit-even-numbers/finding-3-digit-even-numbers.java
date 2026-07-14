class Solution {

    Set<Integer> set = new TreeSet<>();

    public int[] findEvenNumbers(int[] digits) {

        int[] freq = new int[10];

        for (int d : digits) {
            freq[d]++;
        }

        backtrack(freq, 0, 0);

        int[] ans = new int[set.size()];
        int i = 0;

        for (int num : set) {
            ans[i++] = num;
        }
        Arrays.sort(ans);

        return ans;
    }

    private void backtrack(int[] freq, int len, int num) {

        if (len == 3) {
            if (num >= 100 && num % 2 == 0) {
                set.add(num);
            }
            return;
        }

        for (int d = 0; d <= 9; d++) {

            if (freq[d] == 0)
                continue;

            // First digit cannot be 0
            if (len == 0 && d == 0)
                continue;

            freq[d]--;

            backtrack(freq, len + 1, num * 10 + d);

            freq[d]++;
        }
    }
}
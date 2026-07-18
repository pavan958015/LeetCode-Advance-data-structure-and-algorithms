class Solution {

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    private int lcm(int a, int b) {
        if (a == 0) return b;
        return (a / gcd(a, b)) * b;
    }

    public int subarrayLCM(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int l = 1;

            for (int j = i; j < nums.length; j++) {
                l = lcm(l, nums[j]);

                if (l == k)
                    count++;

                if (l > k || k % l != 0)
                    break;
            }
        }

        return count;
    }
}
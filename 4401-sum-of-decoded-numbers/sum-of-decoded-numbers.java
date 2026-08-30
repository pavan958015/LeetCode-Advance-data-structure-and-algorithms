/*
class Solution {
    public int sumDecoded(long[] nums) {

        final long MOD = 1000000007L;
        long ans = 0;

        for (long num : nums) {

            long width = num % 10;
            long d = num / 10;

            int digits = String.valueOf(d).length();

            long pow = (long) Math.pow(10, digits - width);

            long x = d / pow;
            long y = d % pow;

            long value = 1;

            for (long i = 0; i < y; i++) {
                value = (value * x) % MOD;
            }

            ans = (ans + value) % MOD;
        }

        return (int) ans;
    }
}
*/



class Solution {
    public int sumDecoded(long[] nums) {

        final long MOD = 1000000007L;
        long ans = 0;

        for (long num : nums) {

            long width = num % 10;
            long d = num / 10;

            int digits = String.valueOf(d).length();

            long pow = (long) Math.pow(10, digits - width);

            long x = d / pow;
            long y = d % pow;

            long value = 1;

            while (y > 0) {

                if (y % 2 == 1) {
                    value = (value * x) % MOD;
                }

                x = (x * x) % MOD;
                y = y / 2;
            }

            ans = (ans + value) % MOD;
        }

        return (int) ans;
    }
}
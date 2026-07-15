class Solution {
    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public int gcdOfOddEvenSums(int n) {
        // int odd = 0;
        // int even = 0;
        // int currentOdd = 1;
        // int currentEven = 2;

        // for (int count = 0; count < n; count++) {
        //     odd += currentOdd;
        //     currentOdd += 2;

        //     even += currentEven;
        //     currentEven += 2;
        // }

        int sumEven=n*n;
        int sumOdd=n*(n+1);
        // return gcd(odd, even);
        return gcd(sumEven,sumOdd);
    }
}
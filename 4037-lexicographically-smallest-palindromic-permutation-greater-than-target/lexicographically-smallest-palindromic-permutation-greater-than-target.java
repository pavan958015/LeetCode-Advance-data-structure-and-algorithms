class Solution {

/*

My Approach
s
 ↓
half
 ↓
all permutations of half
 ↓
palindrome
 ↓
compare target



Final Approach

s
 ↓
frequency
 ↓
target ke prefix ko follow karo
 ↓
rightmost position par smallest greater character
 ↓
remaining characters sorted
 ↓
palindrome

*/


    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int odd = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                odd++;
                middle = (char) ('a' + i);
            }
        }

        // More than one odd frequency => palindrome impossible
        if (odd > 1) {
            return "";
        }

        // Build frequency of the left half
        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        int halfLen = n / 2;

        // Target's first half
        String targetHalf = target.substring(0, halfLen);

        /*
         * First try to build the smallest half which is
         * greater than targetHalf.
         */
        String greaterHalf = buildGreaterHalf(
            targetHalf,
            halfFreq
        );

        /*
         * Also check whether targetHalf itself can be used.
         * If it can, construct its palindrome and check
         * whether that palindrome is actually > target.
         */
        if (canBuild(targetHalf, halfFreq)) {

            String candidate = buildPalindrome(
                targetHalf,
                middle,
                n
            );

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        /*
         * If equal half is not enough, use the smallest
         * half which is strictly greater.
         */
        if (greaterHalf != null) {

            return buildPalindrome(
                greaterHalf,
                middle,
                n
            );
        }

        return "";
    }

    private boolean canBuild(String str, int[] freq) {

        int[] count = freq.clone();

        for (char ch : str.toCharArray()) {

            int idx = ch - 'a';

            if (count[idx] == 0) {
                return false;
            }

            count[idx]--;
        }

        return true;
    }

    private String buildGreaterHalf(String targetHalf, int[] freq) {

        int n = targetHalf.length();

        /*
         * We try to keep targetHalf's prefix same
         * and make one position greater.
         *
         * Start from the right because we want the
         * smallest possible greater string.
         */
        for (int pos = n - 1; pos >= 0; pos--) {

            int[] count = freq.clone();

            /*
             * Use the prefix [0 ... pos-1] exactly
             * like targetHalf.
             */
            boolean possible = true;

            for (int i = 0; i < pos; i++) {

                int idx = targetHalf.charAt(i) - 'a';

                if (count[idx] == 0) {
                    possible = false;
                    break;
                }

                count[idx]--;
            }

            if (!possible) {
                continue;
            }

            int current = targetHalf.charAt(pos) - 'a';

            /*
             * At this position choose the smallest
             * available character greater than target.
             */
            for (int c = current + 1; c < 26; c++) {

                if (count[c] == 0) {
                    continue;
                }

                count[c]--;

                StringBuilder result = new StringBuilder();

                // Prefix same as target
                result.append(targetHalf, 0, pos);

                // Make this position greater
                result.append((char) ('a' + c));

                // Fill remaining positions with
                // smallest possible characters
                for (int x = 0; x < 26; x++) {

                    while (count[x] > 0) {
                        result.append((char) ('a' + x));
                        count[x]--;
                    }
                }

                return result.toString();
            }
        }

        return null;
    }

    private String buildPalindrome(
        String half,
        char middle,
        int n
    ) {

        StringBuilder result = new StringBuilder();

        result.append(half);

        if (n % 2 == 1) {
            result.append(middle);
        }

        result.append(
            new StringBuilder(half).reverse()
        );

        return result.toString();
    }
}
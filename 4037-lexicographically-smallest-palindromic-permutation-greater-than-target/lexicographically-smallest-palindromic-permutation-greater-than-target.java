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

        if (odd > 1) {
            return "";
        }

        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        int halfLen = n / 2;

        String targetHalf = target.substring(0, halfLen);

        String greaterHalf = buildGreaterHalf(
                targetHalf,
                halfFreq);

        if (canBuild(targetHalf, halfFreq)) {

            String candidate = buildPalindrome(
                    targetHalf,
                    middle,
                    n);

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        if (greaterHalf != null) {

            return buildPalindrome(
                    greaterHalf,
                    middle,
                    n);
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

        for (int pos = n - 1; pos >= 0; pos--) {

            int[] count = freq.clone();

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

                result.append(targetHalf, 0, pos);

                result.append((char) ('a' + c));

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
            int n) {

        StringBuilder result = new StringBuilder();

        result.append(half);

        if (n % 2 == 1) {
            result.append(middle);
        }

        result.append(
                new StringBuilder(half).reverse());

        return result.toString();
    }
}
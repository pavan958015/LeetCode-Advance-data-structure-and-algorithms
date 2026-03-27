class Solution {
    public int maxVowels(String s, int k) {
        int max = 0;
        int count = 0;

        // first window
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }

        max = count;

        // sliding window
        for (int i = k; i < s.length(); i++) {
            // add next char
            if (isVowel(s.charAt(i))) {
                count++;
            }

            // remove previous char
            if (isVowel(s.charAt(i - k))) {
                count--;
            }

            max = Math.max(max, count);
        }

        return max;
    }

    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
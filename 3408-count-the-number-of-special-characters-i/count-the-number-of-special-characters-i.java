class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        boolean lower[] = new boolean[26];
        boolean upper[] = new boolean[26];

        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (ch >= 'a' && ch <= 'z')
                lower[ch - 'a'] = true;
            if (ch >= 'A' && ch <= 'Z')
                upper[ch - 'A'] = true;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (lower[i] && upper[i])
                count++;
        }
        return count;
    }
}
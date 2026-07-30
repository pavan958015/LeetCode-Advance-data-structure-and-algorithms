class Solution {
    public int minimumPushes(String word) {
        int n=word.length();

        int count=0;
        if(n<=8) count= n;
        else if(n<=16) count=8+(n-8)*2;
        else if(n<=24) count=24+(n-16)*3;
        else count=48+(n-24)*4;

        return count;
    }
}
/*

import java.util.*;

class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];

        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        Arrays.sort(freq);

        int ans = 0;
        int pos = 0;

        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) break;

            ans += freq[i] * (pos / 8 + 1);
            pos++;
        }

        return ans;
    }
}
*/
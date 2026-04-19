class Solution {
    // brute force;
    // public String minWindow(String s, String t) {
    //     int minLength=Integer.MAX_VALUE;
    //     int startIndex=-1;
    //     int n=s.length(),m=t.length();
    //     for(int i=0;i<n;i++){
    //         int hash[]=new int[256]; int count=0;
    //         for(int j=0;j<m;j++){
    //             hash[t.charAt(j)]++;
    //         }
    //         for(int j=i;j<n;j++){
    //             if(hash[s.charAt(j)]>0){
    //                 count++;
    //                 hash[s.charAt(j)]--;
    //             }
    //             if(count==m){
    //                 if(j-i+1<minLength){
    //                     minLength=j-i+1;
    //                     startIndex=i;
    //                     break;
    //                 }
    //             }
    //         }
    //     }
    //     return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLength);
    // }

    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        int start = -1, minLen = Integer.MAX_VALUE;
        int l = 0, r = 0;
        int count = 0;

        int[] hash = new int[256];

        for (int i = 0; i < m; i++) {
            hash[t.charAt(i)]++;
        }

        while (r < n) {
            if (hash[s.charAt(r)] > 0) {
                count++;
            }
            hash[s.charAt(r)]--;
            r++;

            while (count == m) {
                if (r - l < minLen) {
                    minLen = r - l;
                    start = l;
                }

                hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0) {
                    count--;
                }
                l++;
            }
        }

        return start == -1 ? "" : s.substring(start, start + minLen);
    }
}
class Solution {
    public int largestAltitude(int[] gain) {
        int ans=0;
        int cur=0;

        for(int n:gain){
            cur+=n;
            ans=Math.max(cur,ans);
        }
        return ans;
    }
}
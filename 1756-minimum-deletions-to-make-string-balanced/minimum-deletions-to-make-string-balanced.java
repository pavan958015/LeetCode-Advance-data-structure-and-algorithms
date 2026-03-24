class Solution {
    public int minimumDeletions(String s) {
        int n=s.length();
        int countA=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a') countA++;
        }
        int mini=countA;

        int countB=0;
        for(int i=1;i<=n;i++){
            if(s.charAt(i-1)=='a') countA--;
            if(s.charAt(i-1)=='b') countB++;
            mini=Math.min(mini,countA+countB);
        }
        return mini;
    }
}
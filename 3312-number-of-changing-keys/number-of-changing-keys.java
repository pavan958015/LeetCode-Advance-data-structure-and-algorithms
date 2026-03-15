class Solution {
    public int countKeyChanges(String s) {
        int ans=0;
        for(int i=1;i<s.length();i++){
            char x=Character.toLowerCase(s.charAt(i-1));
            char y=Character.toLowerCase(s.charAt(i));
            if(x!=y) ans++;
        }
        return ans;
    }
}
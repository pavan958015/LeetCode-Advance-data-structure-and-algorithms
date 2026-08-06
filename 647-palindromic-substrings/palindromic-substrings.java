class Solution {
    private boolean isPalindrome(int i,int j,String s){
        if(i>=j) return true;

        if(s.charAt(i)!=s.charAt(j)){
           return false;
        }
        return isPalindrome(i+1,j-1,s);
    }
    public int countSubstrings(String s) {
        int n=s.length();

        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(i,j,s)){
                    count++;
                }
            }
        }
        return count;
    }
}
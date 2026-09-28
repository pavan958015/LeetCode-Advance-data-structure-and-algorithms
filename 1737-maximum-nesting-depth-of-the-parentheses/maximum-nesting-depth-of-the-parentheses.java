class Solution {
    public int maxDepth(String s) {
        int max=0;
        int open=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                open++;
            }
            if(s.charAt(i)==')'){
                max=Math.max(open,max);
                open--;
            }
        }
        return max;
    }
}
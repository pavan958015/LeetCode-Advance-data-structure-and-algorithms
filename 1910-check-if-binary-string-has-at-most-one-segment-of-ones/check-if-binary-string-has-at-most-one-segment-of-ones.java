class Solution {
    public boolean checkOnesSegment(String s) {
        boolean isZeroLeading=false;

        for(char ch:s.toCharArray()){
            if(ch=='0') isZeroLeading=true;

            if(ch=='1' && isZeroLeading) return false;
        }
        return true;
    }
}
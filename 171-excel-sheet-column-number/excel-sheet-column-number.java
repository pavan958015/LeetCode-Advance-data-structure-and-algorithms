class Solution {
    public int titleToNumber(String columnTitle) {
        int n=columnTitle.length()-1;
        int result=0;
        for(int i = 0; i < columnTitle.length(); i++){
            int value = columnTitle.charAt(i) - 'A' + 1;
            result = result * 26 + value;
        }
        return result;
    }
}
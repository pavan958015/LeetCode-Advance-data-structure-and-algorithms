class Solution {
    public String convertToTitle(int columnNumber) {
        int col=columnNumber;
        StringBuilder str=new StringBuilder();

        while(col>0){
            int idx=(col-1)%26;
            str.append((char)(idx+'A'));
            col=(col-1)/26;
        }
        return str.reverse().toString();
    }
}
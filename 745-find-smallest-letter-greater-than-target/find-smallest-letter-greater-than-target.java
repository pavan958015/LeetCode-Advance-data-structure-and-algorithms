class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n=letters.length;

        for(int i=0;i<n;i++){
            char ch=letters[i];
            if(ch>target) return ch;
        }
        return letters[0];
    }
}
class Solution {
    public int minSteps(String s, String t) {
        int countS[]=new int[26];
        int countT[]=new int[26];   

        for(int i=0;i<s.length();i++){
            countS[s.charAt(i)-'a']++;
            countT[t.charAt(i)-'a']++;
        }

        int count=0;
        for(int i=0;i<26;i++){
            count+=Math.abs(countS[i]-countT[i]);
        }
        return count/2;
    }
}
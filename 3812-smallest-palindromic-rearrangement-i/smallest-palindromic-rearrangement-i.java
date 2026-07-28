class Solution {
    public String smallestPalindrome(String s) {
        int freq[]=new int[26];

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            freq[ch-'a']++;
        }   

        StringBuilder leftPart=new StringBuilder();
        String middle="";

        for(int i=0;i<26;i++){
            if(freq[i]%2==1){
                middle=String.valueOf((char)(i+'a'));
            }
            // add half of the freq;
            for(int j=0;j<freq[i]/2;j++){
                leftPart.append((char)(i+'a'));
            }
        }
        String res=leftPart.toString()+middle+leftPart.reverse().toString();
        return res;
    }
}
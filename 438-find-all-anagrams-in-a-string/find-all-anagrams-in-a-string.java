class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list=new ArrayList<>();
        int sCount[]=new int[26];
        int pCount[]=new int[26];

        for(char x:p.toCharArray()){
            pCount[x-'a']++;
        }

        for(int i=0;i<s.length();i++){
            sCount[s.charAt(i)-'a']++;
            if(i>=p.length()){
                sCount[s.charAt(i-p.length())-'a']--;
            }
            if(Arrays.equals(sCount,pCount)){
                list.add(i-p.length()+1);
            }
        }
        return list;
    }
}
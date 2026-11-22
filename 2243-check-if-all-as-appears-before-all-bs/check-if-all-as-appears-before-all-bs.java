class Solution {
    public boolean checkString(String s) {
        Set<Character> set=new HashSet<>();

        boolean flag=true;
        for(char ch:s.toCharArray()){
            if(ch=='b') set.add(ch);
            if(ch=='a' && set.contains('b')) flag=false;
        }
        return flag;
    }
}
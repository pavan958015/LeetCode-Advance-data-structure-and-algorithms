class Solution {
    private String match(String s1,String s2){
        int min=Math.min(s1.length(),s2.length());

        StringBuilder str=new StringBuilder();
        int i=0;
        while(i<min){
            if(s1.charAt(i)==s2.charAt(i)){
                str.append(s1.charAt(i));
                i++;
            }
            else break;
        }
        return str.toString();
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1) return strs[0];
        
        String res=strs[0];
        for(int i=1;i<strs.length;i++){
            String s=match(res,strs[i]);
            
            // if(s.length()>res.length()) res=s;
            res=s;

        }
        return res;
    }
}
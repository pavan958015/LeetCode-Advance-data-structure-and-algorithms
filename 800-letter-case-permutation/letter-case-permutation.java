class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> res=new ArrayList<>();
        char ch[]=s.toCharArray();
        helper(ch,0,res);
        return res;
    }
    private void helper(char[] ch,int index,List<String> res){
        if(index==ch.length){
            res.add(new String(ch));
            return;
        }
        if(Character.isDigit(ch[index])){
            helper(ch,index+1,res);
        }else{
            
            // Lower Case;
            ch[index]=Character.toLowerCase(ch[index]);
            helper(ch,index+1,res);
            
            // Upper Case
            ch[index]=Character.toUpperCase(ch[index]);
            helper(ch,index+1,res);

        }
    }
}
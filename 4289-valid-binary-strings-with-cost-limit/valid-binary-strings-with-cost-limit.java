class Solution {
    public List<String> generateValidStrings(int n, int k) {
        List<String> list=new ArrayList<>();
        backtrack(0,n,k,0,0,new StringBuilder(),list);
        return list;
    }
    public static void backtrack(int pos,int n,int k,int cost,int prevBit,StringBuilder str,List<String> list){
        if(cost>k) return;

        if(pos==n){
            list.add(new String(str));
            return;
        }

        str.append('0');
        backtrack(pos+1,n,k,cost,0,str,list);
        str.deleteCharAt(str.length()-1);

        if(prevBit==0){
            str.append('1');
            backtrack(pos+1,n,k,cost+pos,1,str,list);
            str.deleteCharAt(str.length()-1);
        }
    }
}
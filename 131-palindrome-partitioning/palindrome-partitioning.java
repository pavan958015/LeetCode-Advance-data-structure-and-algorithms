class Solution {
    private boolean isPalindrome(String s,int l,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> path=new ArrayList<>();

        solve(0,s,res,path);
        return res;
    }
    private void solve(int idx,String s,List<List<String>> res, List<String> path){
        if(idx==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=idx;i<s.length();i++){
            if(isPalindrome(s,idx,i)){
                path.add(s.substring(idx,i+1));
                solve(i+1,s,res,path);
                path.remove(path.size()-1);
            }
        }
    }
}
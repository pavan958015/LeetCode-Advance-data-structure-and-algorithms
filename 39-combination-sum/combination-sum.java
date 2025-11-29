class Solution {
     Set<String> s=new HashSet<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list=new ArrayList<>();
        

        helper(candidates,0,new ArrayList<>(),target,list);
        return list;
    }
    private void helper(int[] arr,int index,ArrayList<Integer> cur,
                        int target ,List<List<Integer>> ans){
        
        // base Condition
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(cur);
            Collections.sort(temp);

            String key = temp.toString();
            if (!s.contains(key)) {
                s.add(key);
                ans.add(temp);
            }
            return;
        }
        if(index==arr.length || target<0) return;

        cur.add(arr[index]);
        // Single Include
        helper(arr,index+1,cur,target-arr[index],ans);
        // multiple Include
        helper(arr,index,cur,target-arr[index],ans);
        // exclude
        cur.remove(cur.size()-1);
        helper(arr,index+1,cur,target,ans);

    }
}
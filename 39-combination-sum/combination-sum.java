class Solution {
     Set<String> set=new HashSet<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list=new ArrayList<>();
        
        helper(0,candidates,new ArrayList<>(),target,list);
        return list;
    }
    private void helper(int index,int[] arr,ArrayList<Integer> cur,
                        int target ,List<List<Integer>> ans){
        
        // base Condition
        if (target == 0) {
            List<Integer> temp = new ArrayList<>(cur);
            // Collections.sort(temp);

            String key = temp.toString();
            if (!set.contains(key)) {
                set.add(key);
                ans.add(temp);
            }
            return;
        }
        if(index==arr.length || target<0) return;

        cur.add(arr[index]);
        // Single Include
        helper(index+1,arr,cur,target-arr[index],ans);
        // multiple Include
        helper(index,arr,cur,target-arr[index],ans);
        // exclude
        cur.remove(cur.size()-1);
        helper(index+1,arr,cur,target,ans);

    }
}
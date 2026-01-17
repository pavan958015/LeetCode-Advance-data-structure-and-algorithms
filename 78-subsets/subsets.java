class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        backTrack(nums,new ArrayList<>(),list,0);
        return list;
    }
    private void backTrack(int[] arr,ArrayList<Integer> cur,List<List<Integer>> list,int index){
        if(index==arr.length){
            list.add(new ArrayList<>(cur));
            return;
        }

        // include the index
        cur.add(arr[index]);
        backTrack(arr,cur,list,index+1);

        // exclude the index
        cur.remove(cur.size()-1);
        backTrack(arr,cur,list,index+1);
    }
}
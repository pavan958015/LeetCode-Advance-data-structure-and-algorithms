class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();

        int powerSet=(1<<n);        // 2^n

        for(int i=0;i<powerSet;i++){
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<n;j++){
                if((i& (1<<j))!=0) list.add(nums[j]);
            }
            ans.add(list);
        }
        return ans;
    }
}











// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> list=new ArrayList<>();
//         backTrack(nums,new ArrayList<>(),list,0);
//         return list;
//     }
//     private void backTrack(int[] arr,ArrayList<Integer> cur,List<List<Integer>> list,int index){
//         if(index==arr.length){
//             list.add(new ArrayList<>(cur));
//             return;
//         }

//         // include the index
//         cur.add(arr[index]);
//         backTrack(arr,cur,list,index+1);

//         // exclude the index
//         cur.remove(cur.size()-1);
//         backTrack(arr,cur,list,index+1);
//     }
// }
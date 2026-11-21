public class Solution {
    public IList<int> FindDuplicates(int[] nums) {
        IList<int> list=new List<int>();

        ISet<int> set=new HashSet<int>();
        int n=nums.Length;
        for(int i=0;i<n;i++){
            if(set.Contains(nums[i])){
                list.Add(nums[i]);
            }else{
                set.Add(nums[i]);
            }
        }
        return list;
    }
}
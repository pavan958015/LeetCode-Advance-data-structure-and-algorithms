public class Solution {
/*
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
*/
    public IList<int> FindDuplicates(int[] nums) {
        IList<int> list=new List<int>();

        int n=nums.Length;
        for(int i=0;i<n;i++){
            int idx=Math.Abs(nums[i])-1;

            if(nums[idx]<0){
                list.Add(Math.Abs(nums[i]));
            }else
                nums[idx]=-nums[idx];
        }
        return list;
    }
}
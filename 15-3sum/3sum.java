class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        if( nums==null || n<3) return new ArrayList<>();

        Set<List<Integer>> res=new HashSet<>();

        Arrays.sort(nums);

        for(int i=0;i<n-2;i++){

            int l=i+1;
            int r=n-1;
            
            while(l<r){
                int sum=nums[i]+nums[l]+nums[r];
                if(sum==0){
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                }else if(sum<0){
                    l++;
                }else{
                    r--;
                }
            }
        }
     return new ArrayList<>(res);
    }
}
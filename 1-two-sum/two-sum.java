class Solution {
    // public int[] twoSum(int[] nums, int target) {
    //     int arr[]=new int[2];
    //     for(int i=0;i<nums.length-1;i++){
    //         for(int j=i+1;j<nums.length;j++){
    //             if(nums[i]+nums[j]==target){
    //                 arr[0]=i;
    //                 arr[1]=j;
    //                 return arr;
    //             }
    //         }
    //     }
    //     arr[0]=-1;
    //     arr[1]=-1;
    //     return arr;
    // }
    public int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            int need = target - nums[i];
            
            if(map.containsKey(need)) return new int[]{map.get(need), i};
            
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}
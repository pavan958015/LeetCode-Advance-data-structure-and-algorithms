class Solution {
    // public int singleNumber(int[] nums) {
    //     Map<Integer,Integer> map=new HashMap<>();
    //     for(int i=0;i<nums.length;i++){
    //         map.put(nums[i],map.getOrDefault(nums[i],0)+1);
    //     }
    //     for(int key:map.keySet()){
    //         if(map.get(key)==1){
    //             return key;
    //         }
    //     }
    //     return -1;
    // }


    public int singleNumber(int nums[]){
        int n=nums.length;
        int ans=0;
        for(int bitIndex=0;bitIndex<=31;bitIndex++){
            int count=0;
            for(int i=0;i<n;i++){
                if((nums[i] & (1<<bitIndex))!=0){
                    count++;
                }
            }
            if(count%3==1) ans=ans| (1<<bitIndex);
        }
        return ans;
    }
}
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans=new ArrayList<>();

        int need=nums.length/3;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            int num=m.getValue();
            if(num>need){
                ans.add(m.getKey());
            }
        }
        return ans;
    }
}
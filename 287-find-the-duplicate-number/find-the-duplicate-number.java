class Solution {
    public int findDuplicate(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i+=1){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }   


        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            int key=m.getKey();
            int val=m.getValue();

            if(val>1) return key;
        }
        return -1;
    }
}
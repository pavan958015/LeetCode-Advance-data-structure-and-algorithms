class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int count=0;
        int element=0;


        for(int num:nums){
            if(count==0){
                element=num;
            }
            if(element==num){
                count++;
            }else{
                count--;
            }
        }
        return element;
    }
}
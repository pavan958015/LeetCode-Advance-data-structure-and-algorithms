class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        if(n<=2) return n;

        int ans=1;

        for(int num:nums){
            if(ans<=n){
                ans=ans<<1;
            }else{
                return ans;
            }
        }  
        return ans; 
    }
}
class Solution {
    public int dominantIndex(int[] nums) {
        int n=nums.length;

        if(n==1) return nums[0];

        int copy[]=nums.clone();
        Arrays.sort(copy);

        int largest=copy[n-1];
        int idx=-1;

        for(int i=0;i<n;i++){
            if(largest==nums[i]){
                idx=i;
                break;
            }
        }
        for(int i=0;i<n-1;i++){
            if(largest<2*copy[i]) return -1;
        }
        return idx;
    }
}
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[n-1];
        }
        int temp1[]=new int[n-1];
        int temp2[]=new int[n-1];

        for (int i = 0; i < n - 1; i++) {
            temp1[i] = nums[i + 1]; // skip first
            temp2[i] = nums[i];     // skip last
        }
        return Math.max(rob1(temp1),rob1(temp2));

    }   
    public int rob1(int[] nums){
        int n=nums.length;
        int prev=nums[0];
        int prev2=0;
        for(int i=1;i<n;i++){
            int accept=nums[i];
            if(i>1)
                accept+=prev2;
            int skip=prev;
            int cur=Math.max(accept,skip);

            prev2=prev;
            prev=cur;
        }
        return prev;
    }
}
class Solution {
    public int rob(int[] nums){
        int n=nums.length;
        if(n==1) return nums[n-1];

        
        int temp1[]=new int[n-1];
        int temp2[]=new int[n-1];
        for(int i=0;i<n-1;i++){
            temp1[i]=nums[i+1];     // skiped First;
            temp2[i]=nums[i];       // skip Last;
        }
        int dp1[]=new int[n-1];
        int dp2[]=new int[n-1];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);

        int first=helper(0,temp1,dp1);
        int last=helper(0,temp2,dp2);

        return Math.max(first,last);
    }
    public static int helper(int idx,int[] arr,int dp[]){
        if(idx>=arr.length) return 0;

        if(dp[idx]!=-1) return dp[idx];

        int take=arr[idx]+helper(idx+2,arr,dp);

        int notTake=helper(idx+1,arr,dp);

        return dp[idx]= Math.max(take,notTake);
    }



    // Space Optimization

    // public int rob(int[] nums) {
    //     int n=nums.length;
    //     if(n==1){
    //         return nums[n-1];
    //     }
    //     int temp1[]=new int[n-1];
    //     int temp2[]=new int[n-1];

    //     for (int i = 0; i < n - 1; i++) {
    //         temp1[i] = nums[i + 1]; // skip first
    //         temp2[i] = nums[i];     // skip last
    //     }
    //     return Math.max(helper(temp1),helper(temp2));

    // }   
    // public int helper(int[] nums){
    //     int n=nums.length;
    //     int prev=nums[0];
    //     int prev2=0;
    //     for(int i=1;i<n;i++){
    //         int accept=nums[i];
    //         if(i>1)
    //             accept+=prev2;
    //         int skip=prev;
    //         int cur=Math.max(accept,skip);

    //         prev2=prev;
    //         prev=cur;
    //     }
    //     return prev;
    // }
}
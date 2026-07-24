// class Solution {
//     public long maxAlternatingSum(int[] A) {
//         long odd = 0, even = 0;
//         for (int a : A) {
//             even = Math.max(even, odd + a);
//             odd = even - a;
//         }
//         return even;
//     }
// }


class Solution {
    public long maxAlternatingSum(int[] nums) 
    {
        int n = nums.length;

        long dp[][] = new long[n][2];
        for(int i=0; i<n; i++)
        {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 0, nums, dp);
        
    }

    static long solve(int idx, int flag, int nums[], long dp[][])
    {
        if(idx == nums.length)
        {
            return 0;
        }

        if(dp[idx][flag] != -1)
        {
            return dp[idx][flag];
        }

        

        // odd
        long include = 0;
        if(flag == 0)
        {
            include = nums[idx] + solve(idx+1, 1, nums, dp);
        }
        // even
        else
        {
            include = -nums[idx] + solve(idx+1, 0, nums, dp);
        }

        long skip = solve(idx+1, flag, nums, dp);

        dp[idx][flag] = Math.max(include, skip);
        return dp[idx][flag];
    }
}
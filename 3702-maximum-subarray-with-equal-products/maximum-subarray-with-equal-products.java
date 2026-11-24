class Solution {
    public int maxLength(int[] nums) 
    {
        int len = 0;

        for(int i=0; i<nums.length; i++)
        {
            int currgcd = nums[i];
            int currprod = nums[i];
            int currlcm = nums[i];

            for(int j=i+1; j <nums.length; j++)
            {
                currgcd = gcd(currgcd, nums[j]);
                currlcm = lcm(currlcm, nums[j]);
                currprod = currprod * nums[j];

                if(currprod == currlcm * currgcd)
                {
                    len = Math.max(len, j-i+1);
                }
            }
        }
        return len;
        
    }

    static int gcd(int x, int y)
    {
        if(y == 0)
        {
            return x;
        }
        return gcd(y , x % y);
    }

    public static int lcm(int a, int b) 
    {
        return (a * b) / gcd(a, b);
    }

}
class Solution {
    public int minMergedInteger(int[] nums) {
        int min=(int)1e9;
        int n=nums.length;

        for(int i=0;i<n-1;i+=2){
            String a=String.valueOf(nums[i]);
            String b=String.valueOf(nums[i+1]);
            int c=Integer.parseInt(a+b);
            if(c<min)
                min=c;
        }
        return min;
    }
}
class Solution {
    public static int sum(int n){
        int sum=0;
        while(n>0){
            int dig=n%10;
            sum+=dig;
            n/=10;
        }
        return sum; 
    }
    public int minElement(int[] nums) {
        int min=Integer.MAX_VALUE;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int sum=sum(nums[i]);
            min=Math.min(sum,min);
        }
        return min;
    }
}
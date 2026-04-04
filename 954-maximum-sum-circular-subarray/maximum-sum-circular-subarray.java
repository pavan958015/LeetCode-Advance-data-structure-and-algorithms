class Solution {
    public static int kadanes(int[] arr){
        int n=arr.length;
        if(n==0) return 0;
        int finalSum=arr[0];
        int temp=arr[0];

        for(int i=1;i<n;i++){
            temp+=arr[i];
            if(temp<arr[i]) temp=arr[i];
            finalSum=Math.max(temp,finalSum);
        }
        return finalSum;
    }
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;

        int usingKadanes=kadanes(nums);
        int total=0;
        for(int i=0;i<n;i++){
            total+=nums[i];
            nums[i]*=-1;
        }

        int afterChangeSign=kadanes(nums);
        int circularSum=total+afterChangeSign;
        if(total+afterChangeSign==0) return usingKadanes;
        return Math.max(usingKadanes,total+afterChangeSign);


    }
}
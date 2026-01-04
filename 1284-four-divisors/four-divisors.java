class Solution {
    public int sumFourDivisors(int[] nums) {
        int total[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int div = 0;
            int sum = 0;
            if(nums[i]<=5){
                total[i]=0;
            }else{
                for(int j=1;j*j<=nums[i];j++){
                    if(nums[i]%j==0){
                        int d1=j;
                        int d2=nums[i]/j;
                        div++;
                        sum += d1;
                        if (d1 != d2) {
                            div++;
                            sum += d2;
                        }
                    }
                }
                if(div==4){
                    total[i]=sum;
                }else{
                   total[i]=0;
                }
            }
        }
        int totalSum=0;
        for(int x:total){
            totalSum+=x;
        }
        return totalSum;
    }
}
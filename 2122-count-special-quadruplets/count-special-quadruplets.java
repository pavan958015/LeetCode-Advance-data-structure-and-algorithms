class Solution {
    public int countQuadruplets(int[] nums) {
        int count=0;
        int n=nums.length;
        for(int i=0;i<n-3;i++){
            for(int j=i+1;j<n-2;j++){
                for(int k=j+1;k<n-1;k++){
                    for(int l=k+1;l<n;l++){
                        int a=nums[i];
                        int b=nums[j];
                        int c=nums[k];
                        int d=nums[l];
                        if(a+b+c==d) count++;
                    }
                }
            }
        }

        return count;
    }
}
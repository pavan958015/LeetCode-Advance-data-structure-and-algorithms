class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;

        int preMax[]=new int[n];
        int postMin[]=new int[n];

        preMax[0]=nums[0];
        for(int i=1;i<n;i++)
            preMax[i]=Math.max(preMax[i-1],nums[i]);

        postMin[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            postMin[i]=Math.min(postMin[i+1],nums[i]);
        }

        for(int i=0;i<n;i++){
            int score=(preMax[i]-postMin[i]);
            if(score<=k) return i;
        }
        return -1;

    }
}

/*
5 0 1 4

5 5 5 5
0 0 1 4

5 5 4 1
      3

*/
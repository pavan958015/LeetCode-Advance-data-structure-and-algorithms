class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int total=0;
        int[] prefixSum=new int[n+1];
        int[] suffixSum=new int[n+1];

        prefixSum[0]=height[0];
        for(int i=1;i<n;i++){
            prefixSum[i]=Math.max(prefixSum[i-1],height[i]);
        }


        suffixSum[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            suffixSum[i]=Math.max(suffixSum[i+1],height[i]);
        }

        for(int i=0;i<n;i++){
            int leftMax=prefixSum[i]; int rightMax=suffixSum[i];
            if(height[i]<leftMax && height[i]<rightMax){
                total+=Math.min(leftMax,rightMax)-height[i];
            }
        }
        return total;
    }
}

// class Solution {
//     public int[] getLeftMax(int[] height, int n) {
//         int[] leftMax = new int[n];
//         leftMax[0] = height[0];
//         for (int i = 1; i < n; i++) {
//             leftMax[i] = Math.max(leftMax[i - 1], height[i]);
//         }
//         return leftMax;
//     }

//     public int[] getRightMax(int[] height, int n) {
//         int[] rightMax = new int[n];
//         rightMax[n - 1] = height[n - 1];
//         for (int i = n - 2; i >= 0; i--) {
//             rightMax[i] = Math.max(rightMax[i + 1], height[i]);
//         }
//         return rightMax;
//     }

//     public int trap(int[] height) {
//         int n = height.length;
//         if (n == 1 || n == 0)
//             return 0;
        
//         int[] leftMax = getLeftMax(height, n);
//         int[] rightMax = getRightMax(height, n);

//         int sum = 0;
//         for (int i = 0; i < n; i++) {
//             sum += Math.min(leftMax[i], rightMax[i]) - height[i];
//         }
//         return sum;
//     }
// }
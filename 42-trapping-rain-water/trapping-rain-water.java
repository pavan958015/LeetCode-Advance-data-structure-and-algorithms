class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int leftMax=0,rightMax=0,total=0;
        int left=0; int right=n-1;

        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>leftMax){
                    leftMax=height[left];
                }else{
                    total+=leftMax-height[left];
                }
                left++;
            }else{
                if(height[right]>rightMax){
                    rightMax=height[right];
                }else{
                    total+=rightMax-height[right];
                }
                right--;
            }
        }
        return total;

    }
}
// extra Space


// class Solution {
//     public int trap(int[] height) {
//         int n = height.length;
//         int total = 0;
//         int[] prefixSum = new int[n + 1];
//         int[] suffixSum = new int[n + 1];

//         prefixSum[0] = height[0];
//         for (int i = 1; i < n; i++) {
//             prefixSum[i] = Math.max(prefixSum[i - 1], height[i]);
//         }

//         suffixSum[n - 1] = height[n - 1];
//         for (int i = n - 2; i >= 0; i--) {
//             suffixSum[i] = Math.max(suffixSum[i + 1], height[i]);
//         }

//         for (int i = 0; i < n; i++) {
//             int leftMax = prefixSum[i];
//             int rightMax = suffixSum[i];
//             if (height[i] < leftMax && height[i] < rightMax) {
//                 total += Math.min(leftMax, rightMax) - height[i];
//             }
//         }
//         return total;
//     }
// }

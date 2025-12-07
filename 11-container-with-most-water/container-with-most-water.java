class Solution {
    public int maxArea(int[] height) {
        int start=0;
        int end=height.length-1;
        int res=0;
        while(start<end){
            int width=end-start;
            int minHeight=Math.min(height[start],height[end]);
            int area=minHeight*width;
            res=Math.max(area,res);
            if(height[start]<height[end]){
                start++;
            }else{
                end--;
            }
        }
        return res;
    }
}
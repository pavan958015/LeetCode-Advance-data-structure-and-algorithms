class Solution {
    private int[] preSmaller(int nums[]){
        int a[]=new int[nums.length];

        Stack<Integer> st=new Stack<>();
        for(int i=0;i<nums.length;i++){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                a[i]=-1;
            }else{
                a[i]=st.peek();
            }
            st.push(i);
        }
        return a;
    }

    private int[] nextSmaller(int nums[]){
        int b[]=new int[nums.length];

        Stack<Integer> st=new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>=nums[i]){
                st.pop();
            }
            if(st.isEmpty()){
                b[i]=nums.length;
            }else{
                b[i]=st.peek();
            }
            st.push(i);
        }
        return b;
    }
    public int largestRectangleArea(int[] heights) {
        int a[]=preSmaller(heights);
        int b[]=nextSmaller(heights);

        int max=Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            int cur=(b[i]-a[i]-1)*heights[i];
            max=Math.max(cur,max);
        }
        return max;
    }
}
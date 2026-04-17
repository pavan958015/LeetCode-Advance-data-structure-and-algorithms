class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        int arr[]=new int[s.length()];

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else if(stack.size()>0){
                int matchedPossion=stack.pop();
                arr[i]=1;
                arr[matchedPossion]=1;
            }
        }
        int max=0;
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1) count++;
            else count=0;
            max=Math.max(max,count);
        }
        return max;
    }
}
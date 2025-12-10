class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder str=new StringBuilder();

        // COnvert nums in to String array;;
        String arr[]=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=String.valueOf(nums[i]);
        }

        // Sort
        Arrays.sort(arr,(a,b)->(b+a).compareTo(a+b));
        if(arr[0].equals("0")) return "0";
        // append
        for(String s:arr){
            str.append(s);
        }
        return str.toString();
    }
}
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();

        for(int x:nums){
            set.add(x);
        }

        int longest=0;

        for(int num:set){
            if(!set.contains(num-1)){
                int length=1;

                while(set.contains(num+length)){
                    length++;
                }

                longest=Math.max(longest,length);
            }
        }
        return longest;
    }
}
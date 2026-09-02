class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set=new HashSet<>();
        for(int x:nums){
            set.add(x);
        }

        for(int i=k;i<1000;i+=k){
            if(!set.contains(i)) return i;
        }
        return -1;
    }
}
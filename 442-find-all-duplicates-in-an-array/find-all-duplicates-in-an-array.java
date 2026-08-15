class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list=new ArrayList<>();
        Set<Integer> set=new HashSet<>();

        for(int x:nums){
            if(set.contains(x)){
                list.add(x);
            }else
                set.add(x);
        }
        return list;
    }
}
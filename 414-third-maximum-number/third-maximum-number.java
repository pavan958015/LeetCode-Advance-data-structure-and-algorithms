class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int x:nums) set.add(x);

        List<Integer> list=new ArrayList<>(set);
        Collections.sort(list);

        if(list.size()>=3) return list.get(list.size()-3);
        else return list.get(list.size()-1);
    }
}
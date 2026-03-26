class Solution {
    // public int thirdMax(int[] nums) {
    //     Set<Integer> set = new HashSet<>();
    //     for (int x : nums)
    //         set.add(x);

    //     List<Integer> list = new ArrayList<>(set);
    //     Collections.sort(list);

    //     if (list.size() >= 3)
    //         return list.get(list.size() - 3);
    //     else
    //         return list.get(list.size() - 1);
    // }

    public int thirdMax(int[] nums) {
        Integer  first = null;
        Integer  second = null;
        Integer  third = null;

        for (int i = 0; i < nums.length; i++) {
            if ((first != null && nums[i] == first) ||
                    (second != null && nums[i] == second) ||
                    (third != null && nums[i] == third))
                continue;
            if (first==null || nums[i] > first) {
                third = second;
                second = first;
                first = nums[i];

            } else if (second==null  || nums[i] > second) {
                third = second;
                second = nums[i];

            } else if(third==null || nums[i]>third) {
                third = nums[i];
            }
        }
        return third==null?first:third;
    }
}
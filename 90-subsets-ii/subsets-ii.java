class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backTrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        
        for (int i = start; i < nums.length; i++) {
          
            if (i > start && nums[i] == nums[i - 1]) continue;
            
            tempList.add(nums[i]);
            backTrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
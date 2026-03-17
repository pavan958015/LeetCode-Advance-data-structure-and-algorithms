class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 1. Frequency count store karne ke liye HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        
        // 2. nums2 check karein aur count kam karte rahein
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1); // Ek count use ho gaya
            }
        }

        // 3. List ko Array mein convert karein
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
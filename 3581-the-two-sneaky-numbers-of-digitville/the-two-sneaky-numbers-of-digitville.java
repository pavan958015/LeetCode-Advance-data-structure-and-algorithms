class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int arr[]=new int[2];
        int i=0;

        Set<Integer> set=new HashSet<>();
        for(int x:nums){
            if(set.contains(x)){
                arr[i++]=x;
            }
            else set.add(x);
        }   
        return arr;
    }
}



/*

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        // Count frequency of each number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) > 1) {
                result.add(key);
            }
        }

        // Convert List to int[]
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }

        return arr;
    }
}

 */
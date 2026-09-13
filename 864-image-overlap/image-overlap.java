class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {

        int n = img1.length;

        List<int[]> nonZero1 = new ArrayList<>();
        List<int[]> nonZero2 = new ArrayList<>();

        // Store coordinates of 1s
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (img1[i][j] == 1) {
                    nonZero1.add(new int[]{i, j});
                }

                if (img2[i][j] == 1) {
                    nonZero2.add(new int[]{i, j});
                }
            }
        }

        int ans = 0;

        Map<String, Integer> mp = new HashMap<>();

        // Compare every 1 in img1 with every 1 in img2
        for (int[] p1 : nonZero1) {

            for (int[] p2 : nonZero2) {

                int x = p2[0] - p1[0];
                int y = p2[1] - p1[1];

                String key = x + "," + y;

                mp.put(key, mp.getOrDefault(key, 0) + 1);

                ans = Math.max(ans, mp.get(key));
            }
        }

        return ans;
    }
}
class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        // add both arrays in list because after sorting index will change both array the add first in list then sort
        int n = plantTime.length;

        List<int[]> flowers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // Store as {plantTime, growTime}
            flowers.add(new int[] { plantTime[i], growTime[i] });
        }
        // Sort the list based on growTime in descending order
        flowers.sort((a, b) -> b[1] - a[1]);

        int maxDayTime=0;
        int prevPlantTime=0;

        for(int i=0;i<n;i++){
            int curPlantTime=flowers.get(i)[0];
            int curBlowTime=flowers.get(i)[1];

            prevPlantTime+=curPlantTime;

            int bloomTime=prevPlantTime+curBlowTime;

            maxDayTime=Math.max(maxDayTime,bloomTime);
        }
        return maxDayTime;
    }
}
class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int minVal=arrays.get(0).get(0);
        int maxVal=arrays.get(0).get(arrays.get(0).size()-1);

        int ans=0;
        for(int i=1;i<arrays.size();i++){
            List<Integer> cur=arrays.get(i);

            int curMin=cur.get(0);
            int curMax=cur.get(cur.size()-1);

            ans=Math.max(ans,Math.max(curMax-minVal,maxVal-curMin));

            minVal=Math.min(minVal,curMin);
            maxVal=Math.max(maxVal,curMax);

        }
        return ans;
    }
}
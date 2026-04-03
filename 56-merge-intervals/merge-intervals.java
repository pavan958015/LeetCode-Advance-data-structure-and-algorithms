class Solution {
    public int[][] merge(int[][] intervals) {
        // sort intervals based on start time;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        List<int[]> merged=new ArrayList<>();


        // first interval;
        int[] prev=intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<=prev[1]){
                prev[1]=Math.max(prev[1],intervals[i][1]);
            }
            else{
                merged.add(prev);
                prev=intervals[i];
            }
        }

        // last intervals;
        merged.add(prev);
        return merged.toArray(new int[merged.size()][]);

    }
}
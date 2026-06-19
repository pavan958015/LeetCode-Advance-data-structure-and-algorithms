class Solution {
    // Infoyes Question
    // https://www.youtube.com/watch?v=YvnawP6tWww
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n=profit.length;
        int m=worker.length;

        // I can use seprate array also difficulty and profit I use this i same array for better understanding 
        int task[][]=new int[n][2];

        for(int i=0;i<n;i++){
            task[i][0]=difficulty[i];
            task[i][1]=profit[i];
        }
        Arrays.sort(task,(a,b)->a[0]-b[0]);
        Arrays.sort(worker);

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        int ans=0;
        int bestProfit = 0;
        int i=0;
        for(int j=0;j<m;j++){
            while(i<n && task[i][0]<=worker[j]){
                bestProfit = Math.max(bestProfit, task[i][1]);
                i++;
            }
            ans+=bestProfit;
        }
        return ans;
    }
}
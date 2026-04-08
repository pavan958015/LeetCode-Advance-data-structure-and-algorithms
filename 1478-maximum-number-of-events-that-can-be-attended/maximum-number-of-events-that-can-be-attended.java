class Solution {
    public int maxEvents(int[][] events) {
        int n=events.length;

        // sort based on start time
        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));

        PriorityQueue<Integer> pq=new PriorityQueue<>();

        int totalEvent=0;
        int i=0;

        for(int d=1;d<=100000;d++){
            while(i<n && events[i][0]==d){
                pq.add(events[i][1]);
                i++;
            }
            // if event done before d days;  
            while(!pq.isEmpty() && pq.peek()<d){
                pq.poll();
            }

            // attend event
            if(!pq.isEmpty()){
                pq.poll();
                totalEvent++;
            }
        }
        return totalEvent;
    }
}
class Solution {

    // using BFS
    public boolean canReach(int[] arr,int start){
        Queue<Integer> q=new LinkedList<>();
        boolean vis[]=new boolean[arr.length];

        q.add(start);
        while(!q.isEmpty()){
            int cur=q.poll();

            if(arr[cur]==0) return true;

            int next=cur+arr[cur];
            int prev=cur-arr[cur];

            if(next>=0 && next<arr.length && !vis[next]){
                q.add(next);
                vis[next]=true;
            }
            if(prev>=0 && prev<arr.length && !vis[prev]){
                q.add(prev);
                vis[prev]=true;
            }
        }
        return false;
    }
    // using Recursion

    // public boolean canReach(int[] arr, int start) {

    //     // out of bounds
    //     if(start < 0 || start >= arr.length)
    //         return false;

    //     // already visited
    //     if(arr[start] < 0)
    //         return false;

    //     // reached zero
    //     if(arr[start] == 0)
    //         return true;

    //     int jump = arr[start];

    //     // mark visited
    //     arr[start] = -arr[start];

    //     return canReach(arr, start + jump) ||
    //            canReach(arr, start - jump);
    // }
}
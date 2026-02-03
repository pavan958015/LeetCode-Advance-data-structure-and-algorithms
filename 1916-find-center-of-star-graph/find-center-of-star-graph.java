class Solution {
    // public int findCenter(int[][] edges) {
    //     int nodes = edges.length + 1;
    //     int[][] matrix=new int[nodes+1][nodes+1];
    //     for(int[] e:edges){
    //         int u=e[0];
    //         int v=e[1];
    //         matrix[u][v]=1;
    //         matrix[v][u]=1;

    //     }
    //     for(int i=0;i<=nodes;i++){
    //         int count=0;
    //         for(int j=0;j<=nodes;j++){
    //             if(matrix[i][j]==1){
    //                 count++;
    //             }
    //         }
    //         if(count==nodes-1){
    //             return i;
    //         }
    //     }
    //     return -1;
    // }


    //  public int findCenter(int[][] edges){
    //        int m=edges.length;
    //        int n=m+1;
    //        List<List<Integer>> adj=new ArrayList<>();
    //        for(int i=0;i<m;i++){
    //             int u=edges[i][0];
    //             int v=edges[i][1];

                
    //        }
    //        for(int i=1;i<=n;i++){
    //             if(adj.get(i).size()==n-1){
    //                 return i;
    //             }
    //        }
    //        return -1;
    //  }

    public int findCenter(int[][] edges){
        int a=edges[0][0];
        int b=edges[0][1];
        int c=edges[1][0];
        int d=edges[1][1];
        if(a==c || a==d) return a;
        return b;
    }
}
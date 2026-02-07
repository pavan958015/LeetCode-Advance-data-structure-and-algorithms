class Solution {
    // using 2d matrix
    // public int findCenter(int[][] edges) {
    //     // find nodes
    //     int nodes=edges.length+1;
    //     // make 2d matrix;
    //     int[][] matrix=new int[nodes+1][nodes+1];
    //     // find edges and store one 
    //     for(int i=0;i<edges.length;i++){
    //         for(int e[]:edges){
    //             int u=e[0];
    //             int v=e[1];
    //             matrix[u][v]=1;
    //             matrix[v][u]=1;

    //         }
    //     }
    //     // count each node which has n-1 edges;
    //     for(int i=0;i<=nodes;i++){
    //         int count=0;
    //         for(int j=0;j<=nodes;j++){
    //             if(matrix[i][j]==1) count++;
    //         }
    //         if(count==nodes-1) return i;
    //     }
    //     return -1;
    // }


    // using adjancy List

    //  public int findCenter(int[][] edges) {
    //     int nodes=edges.length+1;
    //     List<List<Integer>> adj=new ArrayList<>();
    //     for(int i=0;i<=nodes;i++){
    //         adj.add(new ArrayList<>());
    //     }
    //         for(int e[]:edges){
    //             int u=e[0];
    //             int v=e[1];
    //             adj.get(u).add(v);
    //             adj.get(v).add(u);
    //         }
        
    //     // for(int i=0;i<adj.size();i++){
    //     //     System.out.print(i+"->");
    //     //     for(int x:adj.get(i)){
    //     //         System.out.print(x+" ");
    //     //     }
    //     //     System.out.println();
    //     // }

    //     for(int i=0;i<=nodes;i++){
    //         if(adj.get(i).size()==nodes-1) return i;
    //     }
    //     return -1;
    //  }

    // using optimal approach -> common value in each edges

    public int findCenter(int[][] edges) {
        int a=edges[0][0];
        int b=edges[0][1];
        int c=edges[1][0];
        int d=edges[1][1];

        // check a->c || a->d
        if(a==c || a==d) return a;
        else return b;

    }
}
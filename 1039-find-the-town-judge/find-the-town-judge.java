class Solution {
    //using matrix;
    // public int findJudge(int n, int[][] trust) {
    //     int[][] matrix = new int[n + 1][n + 1];

    //     for (int i = 0; i < trust.length; i++) {
    //         for (int j = 0; j < trust[0].length; j++) {
    //             int a = trust[i][0];
    //             int b = trust[i][1];

    //             matrix[a][b] = 1;
    //         }
    //     }
    //     for (int i = 1; i <= n; i++) {
    //         int out = 0;
    //         int in = 0;
    //         for (int j = 1; j <= n; j++) {
    //             if (matrix[i][j] == 1)
    //                 out++;
    //             if (matrix[j][i] == 1)
    //                 in++;

    //             if (out == 0 && in == n - 1)
    //                 return i;
    //         }
    //     }

    //     // for(int i=1;i<=n;i++){
    //     //     for(int j=1;j<=n;j++){
    //     //         System.out.print(matrix[i][j]+" ");
    //     //     }
    //     //     System.out.println();
    //     // }
    //     return -1;
    // }

    // using adjancy list;
    public int findJudge(int n, int[][] trust) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[n + 1];
        for (int t[] : trust) {
            int a = t[0];
            int b = t[1];
            adj.get(a).add(b);
            indegree[b]++;
        }
        for (int i = 1; i < adj.size(); i++) {
            int out = adj.get(i).size();
            if (out == 0 && indegree[i] == n - 1)
                return i;

        }
        return -1;
    }
}
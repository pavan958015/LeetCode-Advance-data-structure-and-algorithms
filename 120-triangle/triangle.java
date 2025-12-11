class Solution {
    /*public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        

        int [][]dp=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        
        return solve(triangle,0,0,dp);
    }
    private int solve(List<List<Integer>> list, int i,int j,int[][] dp){
        if(i==list.size()-1){
            return list.get(i).get(j);

        }
        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];

        int down=solve(list,i+1,j,dp);
        int right=solve(list,i+1,j+1,dp);

        return dp[i][j]=list.get(i).get(j)+Math.min(down,right);
    }
    */
    public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    int dp[][] = new int[n][n];


    for (int j = 0; j < triangle.get(n - 1).size(); j++) {
        dp[n - 1][j] = triangle.get(n - 1).get(j);
    }

    for (int i = n - 2; i >= 0; i--) {
        for (int j = 0; j < triangle.get(i).size(); j++) {
            int down = dp[i + 1][j];
            int diag = dp[i + 1][j + 1];

            dp[i][j] = triangle.get(i).get(j) + Math.min(down, diag);
        }
    }

    return dp[0][0];
}

}
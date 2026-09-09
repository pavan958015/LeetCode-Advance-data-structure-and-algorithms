class Solution {
    int n;
    int m;
    public int calculateMinimumHP(int[][] dungeon) {
        n=dungeon.length;
        m=dungeon[0].length;

        int low=1;
        int high=2000001;


        while(low<=high){
            int mid=low+(high-low)/2;

            int[][] dp=new int[n][m];

            if(isValid(0,0,mid,dungeon,dp)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    private boolean isValid(int i,int j,int energy,int[][] matrix,int[][] dp){
        if(i>=n || j>=m) return false;

        if(dp[i][j]>=energy) return false;

        dp[i][j]=energy;

        energy+=matrix[i][j];

        if(energy<=0) return false;

        if(i==n-1 && j==m-1){
            if(energy>0) return true;
        }

        boolean down=isValid(i+1,j,energy,matrix,dp);
        boolean right=isValid(i,j+1,energy,matrix,dp);

        return down || right;
    }
}
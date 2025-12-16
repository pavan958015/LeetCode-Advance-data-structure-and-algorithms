public class Solution {
    public  int calculateMinimumHP(int[][] dungeonGame) {
        int m = dungeonGame.length;
        int n = dungeonGame[0].length;

        // using binary search
        int low = 1;
        int high = (int) 1e9;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(dungeonGame, mid, m, n)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isPossible(int[][] arr,int mid,int m,int n){
        int grid[][]=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=-1;
            }
        }
        grid[0][0]=mid+arr[0][0];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 && j==0) continue;
                int up=Integer.MIN_VALUE;
                int left=Integer.MIN_VALUE;

                if(i>0 && grid[i-1][j]>0) up=grid[i-1][j]+arr[i][j];
                if(j>0 && grid[i][j-1]>0) left=grid[i][j-1]+arr[i][j];

                grid[i][j]=Math.max(up,left);
            }

        }
        return grid[m-1][n-1]>0;

    }

}

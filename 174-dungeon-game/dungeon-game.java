// public class Solution {
    
//     public  int calculateMinimumHP(int[][] dungeonGame) {
//         int m = dungeonGame.length;
//         int n = dungeonGame[0].length;

//         // using binary search
//         int low = 1;
//         // int high = 4*(int) 1e7;
//         int high=400000;
//         int ans = 0;
//         while (low <= high) {
//             int mid = low + (high - low) / 2;

//             if (isPossible(dungeonGame, mid, m, n)) {
//                 ans = mid;
//                 high = mid - 1;
//             } else {
//                 low = mid + 1;
//             }
//         }
//         return ans;
//     }

//     public static boolean isPossible(int[][] arr,int mid,int m,int n){
    
//         int grid[][]=new int[m][n];
        
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 grid[i][j]=-1;
//             }
//         }
//         grid[0][0]=mid+arr[0][0];
//         for(int i=0;i<grid.length;i++){
//             for(int j=0;j<grid[0].length;j++){
//                 if(i==0 && j==0) continue;
//                 int up=Integer.MIN_VALUE;
//                 int left=Integer.MIN_VALUE;

//                 if(i>0 && grid[i-1][j]>0) up=grid[i-1][j]+arr[i][j];
//                 if(j>0 && grid[i][j-1]>0) left=grid[i][j-1]+arr[i][j];

//                 grid[i][j]=Math.max(up,left);
//             }
//         }
//         return grid[m-1][n-1]>0;
//     }
// }


import java.util.Arrays;

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        // Memoization table initialized to -1
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return solve(0, 0, dungeon, memo);
    }

    private int solve(int i, int j, int[][] dungeon, int[][] memo) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        // Base Case: Reached the princess cell (bottom-right)
        if (i == m - 1 && j == n - 1) {
            return dungeon[i][j] <= 0 ? 1 - dungeon[i][j] : 1;
        }

        // Return memoized result if available
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int minHealthFromNext = Integer.MAX_VALUE;

        // Move Down
        if (i + 1 < m) {
            minHealthFromNext = Math.min(minHealthFromNext, solve(i + 1, j, dungeon, memo));
        }

        // Move Right
        if (j + 1 < n) {
            minHealthFromNext = Math.min(minHealthFromNext, solve(i, j + 1, dungeon, memo));
        }

        // Calculate health needed at (i, j)
        int healthNeeded = minHealthFromNext - dungeon[i][j];

        // Health must always be at least 1
        memo[i][j] = healthNeeded <= 0 ? 1 : healthNeeded;

        return memo[i][j];
    }
}
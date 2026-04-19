class Solution {
    public static void dfs(int i,int j,int old,int color,int[][] image){
        int n=image.length; int m=image[0].length;
        if(i<0 || i>=n || j<0 || j>=m || image[i][j]!=old) return;

        image[i][j]=color;

        dfs(i+1,j,old,color,image);
        dfs(i,j+1,old,color,image);
        dfs(i-1,j,old,color,image);
        dfs(i,j-1,old,color,image);

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;

        int oldColor=image[sr][sc];

        if(oldColor==color) return image;

        dfs(sr,sc,oldColor,color,image);
        return image;
    }
}
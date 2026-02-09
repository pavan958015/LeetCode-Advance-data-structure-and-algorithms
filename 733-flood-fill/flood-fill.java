class Solution {

    // ** vis is not required because don't need vis after change colr of the image 

    public void dfs(int i, int j, int[][] image, int oldColor, int newColor, int n, int m) {

        if(i<0 || j<0 || i>=n || j>=m || image[i][j]!=oldColor)
            return;

        image[i][j] = newColor;

        dfs(i-1, j, image, oldColor, newColor, n, m);
        dfs(i+1, j, image, oldColor, newColor, n, m);
        dfs(i, j-1, image, oldColor, newColor, n, m);
        dfs(i, j+1, image, oldColor, newColor, n, m);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int n = image.length;
        int m = image[0].length;

        int oldColor = image[sr][sc];

        // ** if color is same 
        if(oldColor == color)
            return image;

        dfs(sr, sc, image, oldColor, color, n, m);

        return image;
    }
}

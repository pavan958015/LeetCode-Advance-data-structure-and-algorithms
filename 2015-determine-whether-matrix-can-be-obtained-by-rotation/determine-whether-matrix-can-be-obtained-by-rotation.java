class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        
        int n=mat.length;
        for(int i=0;i<4;i++){
            if(isEqual(mat,target)) return true;
            mat=rotate(mat);
        }
        return false;

    }
    public static boolean isEqual(int[][] a,int[][] b){
        int n=a.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(a[i][j]!=b[i][j]) return false;
            }
        }
        return true;
    }
    public static int[][] rotate(int mat[][]){
        int n=mat.length;
        int rotated_Matrix[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                rotated_Matrix[i][j]=mat[n-j-1][i];
            }
        }
        return rotated_Matrix;
    }
}
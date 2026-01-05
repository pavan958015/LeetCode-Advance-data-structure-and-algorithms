class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum=0;
        int min=(int)1e9;
        int n=matrix.length;
        int m=matrix[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]<0)
                    count++;
                min=Math.min(min,Math.abs(matrix[i][j]));
                sum+=Math.abs(matrix[i][j]);
            }
        }
        if(count%2==1){
            sum-=2*min;
        }
        return sum;
    }
}
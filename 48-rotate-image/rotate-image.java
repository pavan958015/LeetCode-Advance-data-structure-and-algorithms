class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        // transpose;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        
        // reverse each row;
        for(int i=0;i<n;i++){
            reverse(matrix[i]);
        }
    }
    public static void reverse(int arr[]){
        int l=0;int r=arr.length-1;
        while(l<r){
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
        }
    }
}
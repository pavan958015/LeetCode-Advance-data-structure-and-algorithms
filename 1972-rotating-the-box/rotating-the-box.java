class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int n=boxGrid.length;
        int m=boxGrid[0].length;

        char[][] finalGrid=new char[m][n];

        for(int i=0;i<n;i++){
            int emptySlot=m-1;
            for(int j=m-1;j>=0;j--){
                if(boxGrid[i][j]=='#'){
                    boxGrid[i][j]='.';
                    boxGrid[i][emptySlot]='#';
                    emptySlot--;
                }else if(boxGrid[i][j]=='*'){
                    emptySlot=j-1;
                }
            }   
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                finalGrid[j][n-1-i]=boxGrid[i][j];
            }
        }
        return finalGrid;
    }
}



// class Solution {
//     public char[][] rotateTheBox(char[][] box) {

//         int n = box.length;
//         int m = box[0].length;

//         char[][] res = new char[m][n];

//         for(int i = 0; i < n; i++) {
//             for(int j = 0; j < m; j++) {
//                 res[j][n - 1 - i] = box[i][j];
//             }
//         }

//         for(int col = 0; col < n; col++) {

//             int empty = m - 1;

//             for(int row = m - 1; row >= 0; row--) {

//                 if(res[row][col] == '*') {
//                     empty = row - 1;
//                 }
//                 else if(res[row][col] == '#') {

//                     res[row][col] = '.';
//                     res[empty][col] = '#';
//                     empty--;
//                 }
//             }
//         }

//         return res;
//     }
// }
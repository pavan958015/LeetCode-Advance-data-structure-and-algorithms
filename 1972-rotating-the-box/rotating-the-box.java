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
                }else if(boxGrid[i][j]=='.'){

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
// class Solution {
//     public boolean divisorGame(int n) {
//         if(n<=1) return false;
//         for(int i = 1; i<n; i++){
//             if(n%i == 0){
//                 return !divisorGame(n-i);
//             }
//         }
//         return false;
//     }
// }



//  class Solution {
//      public boolean divisorGame(int n) {
//         if(n%2==0) return true;
//         return false;
//      }
//  }


class Solution{
    // public boolean divisorGame(int n){
    //     // 1        2       3        4          5           6
    //     // false   true    false     true      false       true

    //     if(n%2==0) return true;
    //     else return false;
    // }

    public boolean divisorGame(int n){
        if(n<=1) return false;
        for(int i=1;i<n;i++){
            if(n%i==0) return !divisorGame(n-i);
        }
        return false;
    }
}
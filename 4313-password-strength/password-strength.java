// class Solution {
//     public int passwordStrength(String password) {
//         boolean lower[]=new boolean[26];
//         boolean upper[]=new boolean[26];
//         boolean number[]=new boolean[10];
//         boolean ex=false;
//         boolean ad=false;
//         boolean hash=false;
//         boolean dol=false;

//         int ans=0;
//         for(char ch:password.toCharArray()){
//             if(ch>='a' && ch<='z' && !lower[ch-'a']){
//                 lower[ch-'a']=true;
//                 ans+=1;
//             }
//             if(ch>='A' && ch<='Z' && !upper[ch-'A']){
//                 upper[ch-'A']=true;
//                 ans+=2;
//             }
//             if(ch>='0' && ch<='9' && !number[ch-'0']){
//                 number[ch-'0']=true;
//                 ans+=3;
//             }
//             if(ch=='!' && !ex){
//                 ex=true;
//                 ans+=5;
//             }
//             if(ch=='@' && !ad){
//                 ad=true;
//                 ans+=5;
//             }
//             if(ch=='#' && !hash){
//                 hash=true;
//                 ans+=5;
//             }
//             if(ch=='$' && !dol){
//                 dol=true;
//                 ans+=5;
//             }
//         }
//         return ans;

//     }
// }


import java.util.*;

class Solution {
    public int passwordStrength(String password) {
        Set<Character> seen = new HashSet<>();
        int ans = 0;

        for (char ch : password.toCharArray()) {

            if (seen.contains(ch)) continue;
            seen.add(ch);

            if (ch >= 'a' && ch <= 'z') ans += 1;
            else if (ch >= 'A' && ch <= 'Z') ans += 2;
            else if (ch >= '0' && ch <= '9') ans += 3;
            else if ("!@#$".indexOf(ch) != -1) ans += 5;
        }

        return ans;
    }
}
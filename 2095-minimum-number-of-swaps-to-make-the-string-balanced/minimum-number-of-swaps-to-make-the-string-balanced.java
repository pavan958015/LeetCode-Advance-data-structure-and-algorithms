class Solution {
    public int minSwaps(String s) {
        // let's take for [ -> 1 and ]-> -1
        // when the balance negative then swap will be needed

        int swap=0;
        int balance=0;

        for(char ch:s.toCharArray()){
            if(ch=='[') balance++;
            if(ch==']') balance--;

            if(balance<0){
                swap++;
                balance=1;
            }
        }
        return swap;
    }
}
class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score=0;
        int res=0;
        int left=0;
        int right=tokens.length-1;
        Arrays.sort(tokens);

        while(left<=right){
            if(power>=tokens[left]){
                power-=tokens[left];
                score++;
                left++;
                res=Math.max(res,score);
            }else if(score>0){
                power+=tokens[right];
                score--;
                right--;
            }else{
                break;
            }
        }

        return res;
    }
}
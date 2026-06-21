class Solution {
    // using Greedy
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count=0;

        for(int n:costs){
            if(n<=coins){
                count++;
                coins-=n;
            }else{
                break;
            }
        }
        return count;
    }
}
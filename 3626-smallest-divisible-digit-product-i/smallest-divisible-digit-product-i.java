class Solution {
    private int product(int n){
        int mul=1;

        while(n>0){
            int d=n%10;
            mul*=d;
            n=n/10;
        }
        return mul;
    }
    public int smallestNumber(int n, int t) {
        for(int i=n;i<=100;i++){
            if(product(i)%t==0) return i;
        }
        return 0;
    }
}
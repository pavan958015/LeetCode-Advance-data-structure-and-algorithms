class Solution {
    private int sum(int n){
        int sum=0;
        while(n>0){
            int d=n%10;
            sum+=d;
            n/=10;
        }
        return sum;
    }
    private int mul(int n){
        int mul=1;
        while(n>0){
            int d=n%10;
            mul*=d;
            n/=10;
        }
        return mul;
    }
    public boolean checkDivisibility(int n) {
        int add=sum(n);
        int mul=mul(n);

        int sum=add+mul;
        return n%sum==0;
    }
}
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
    public int addDigits(int num) {
        // int res=0;
        while(num>9){
            num=sum(num);
        }
        return num;
    }
}
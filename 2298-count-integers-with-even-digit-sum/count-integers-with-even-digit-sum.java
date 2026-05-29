class Solution {
    public static int sum(int n){
        int sum=0;
        while(n>0){
            int d=n%10;
            sum+=d;
            n/=10;
        }
        return sum;

    }
    public int countEven(int num) {
        int count=0;
        for(int i=1;i<=num;i++){
            if(sum(i)%2==0) count++;
        }
        return count;
    }
}
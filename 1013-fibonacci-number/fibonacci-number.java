class Solution {
    public int fib(int n) {
        // if(n<=1) return n;
        // return fib(n-1)+fib(n-2);

        if(n==0) return 0;
        int a=0;
        int b=1;
        int c=a+b;
        for(int i=2;i<=n;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return b;
    }
}
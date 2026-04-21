class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int reverse=findReverse(x);
        System.out.println(reverse);
        if(reverse==x) return true;
        return false;
    }
    public static int findReverse(int x){
        int n=0;
        while(x!=0){
            int d=x%10;

            x/=10;
            n=n*10+d;
        }
        return n;
    }
}
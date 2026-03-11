class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
        return deciToBinary(n);
    }

    public static int deciToBinary(int n){
        int b = 0;
        int res = 0;
        if(n==0) return 1;


        while(n != 0){
            int r = n % 2;
            res += (int)Math.pow(2, b) * (1 - r);
            n = n / 2;
            b++;
        }

        return res;
    }
}
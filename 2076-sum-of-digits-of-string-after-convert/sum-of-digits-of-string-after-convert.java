class Solution {
    private int sum(int n){
        int sum = 0;
        while(n > 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public int getLucky(String s, int k) {
        int number = 0;

        for(int i = 0; i < s.length(); i++){
            int pos = s.charAt(i) - 'a' + 1;
            number += (pos % 10) + (pos / 10);
        }

        k--; // first transformation already done

        while(k > 0){
            number = sum(number);
            k--;
        }

        return number;
    }
}
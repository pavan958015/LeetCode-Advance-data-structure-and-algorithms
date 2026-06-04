class Solution {
    public int totalWaviness(int num1, int num2) {
        int waviness = 0;

        for(int n=num1;n<=num2;n++){
            String s=String.valueOf(n);
            int peak=0;
            int valley=0;
            for(int i=1;i<s.length()-1;i++){
                char ch=s.charAt(i);
                char pre=s.charAt(i-1);
                char post=s.charAt(i+1);

                if(ch-'0'>pre-'0' && ch-'0'>post-'0') peak++;
                if(ch-'0'<pre-'0' && ch-'0'<post-'0') valley++;
            }
            waviness+=peak+valley;
        }
        return waviness;

    }
}
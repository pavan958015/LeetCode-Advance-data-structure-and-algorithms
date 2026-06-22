class Solution {
    public int maxNumberOfBalloons(String text) {
        
        int min=0;
        int b=0,a=0,n=0,l=0,o=0;
        for(int i=0;i<text.length();i++){
            char ch=text.charAt(i);
            if(ch=='b') b++;
            else if(ch=='a') a++;
            else if(ch=='n') n++;
            else if(ch=='l') l++;
            else if(ch=='o') o++;

            min=Math.min(b,Math.min(a,Math.min(n,Math.min(l/2,o/2))));
        }
        return min;
    }
}
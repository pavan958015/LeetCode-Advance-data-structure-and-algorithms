class Solution {
    public void reverseString(char[] s) {
         int left=0,
         right=s.length-1;
        //  reverse(left,right,s);
        reverseLoop(left,right,s);
    }
    // public void reverse(char[]s,int left,int right){
    //     if(left>=right)
    //         return;
    //     int a=(int)(s[left]);
    //     int b=(int)(s[right]);

    //     a=a+b;
    //     b=a-b;
    //     a=a-b;
    //     s[left]=(char)(a);
    //     s[right]=(char)(b);

    //     reverse(s,left+1,right-1);
    // }


    // public static void reverse(int left,int right,char[] s){
    //     if(left>right) return;
    //     char temp=s[left];
    //     s[left]=s[right];
    //     s[right]=temp;
    //     reverse(left+1,right-1,s);
    // }

    
    public static void reverseLoop(int i,int j,char [] s){
        while(i<j){
            char temp=s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
    }
}
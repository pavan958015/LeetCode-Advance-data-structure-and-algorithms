class Solution {
    public int secondHighest(String s) 
    {
        int largest = -1;
        int secLargest = -1;

        for(int i = 0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            if(Character.isDigit(ch))
            {
                int d = Integer.parseInt(ch+"");

                if(d > largest)
                {
                    secLargest = largest;
                    largest = d;
                }

                else if(d < largest && d > secLargest)
                {
                    secLargest = d;
                }
            }
        }
        return secLargest;
    }
}
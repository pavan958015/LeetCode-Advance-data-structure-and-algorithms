class Solution {
    public int findComplement(int num) 
    {
        String binary = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder(binary);

        for(int i=0; i<sb.length(); i++)
        {
            if(sb.charAt(i) == '1')
            {
                sb.setCharAt(i, '0');
            }
            else
            {
                sb.setCharAt(i, '1');
            }
        }

        int n = Integer.parseInt(sb.toString(), 2);

        return n;
        
    }
}
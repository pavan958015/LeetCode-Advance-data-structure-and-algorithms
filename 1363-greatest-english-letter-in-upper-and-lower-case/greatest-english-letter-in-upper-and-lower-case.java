class Solution {
    public String greatestLetter(String s) 
    {
        String str = "";
        for(char ch = 'a'; ch <= 'z'; ch++)
        {
            int i = s.indexOf(ch);

            if(i != -1)
            {
                int j = s.indexOf(Character.toUpperCase(ch));
                if(j != -1)
                {
                    str = Character.toUpperCase(ch)+"";
                }
            }
        }
        return str;
    }
}
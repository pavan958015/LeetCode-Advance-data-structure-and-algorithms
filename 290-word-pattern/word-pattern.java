class Solution {
    public boolean wordPattern(String pattern, String s) {
        String str[] = s.split(" ");

        if (pattern.length() != str.length)
            return false;

        Map<Character, String> mapCharToString = new HashMap<>();
        Map<String, Character> mapStringToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String temp = str[i];

            if (mapCharToString.containsKey(ch)) {
                if (!mapCharToString.get(ch).equals(temp))
                    return false;
            } else
                mapCharToString.put(ch, temp);

            if (mapStringToChar.containsKey(temp)) {
                if (mapStringToChar.get(temp) != ch)
                    return false;
            } else
                mapStringToChar.put(temp, ch);

        }
        return true;
    }
}
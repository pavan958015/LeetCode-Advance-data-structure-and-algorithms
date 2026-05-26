class Solution {
    public int numberOfSpecialChars(String word) {
        // char idx
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isUpperCase(ch) && !map.containsKey(ch)) {
                map.put(ch, i);
            }
        }

        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (Character.isLowerCase(c)) {
                char ch = Character.toUpperCase(c);

                if (map.containsKey(ch) && word.lastIndexOf(c) < map.get(ch)) {
                    count++;
                    map.remove(ch);
                }
            }
        }
        return count;
    }
}
class Solution {
    static class Pair {
        String word;
        int step;

        Pair(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = wordList.size();

        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();

        for (String s : wordList) {
            set.add(s);
        }

        q.add(new Pair(beginWord, 1));
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }

        while (!q.isEmpty()) {
            Pair p = q.poll();
            String word = p.word;
            int step = p.step;

            if (word.equals(endWord))
                return step;

            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] str = word.toCharArray();
                    str[i] = ch;

                    String newStr = new String(str);
                    if (set.contains(newStr)) {
                        q.add(new Pair(newStr, step + 1));
                        set.remove(newStr);
                    }
                }
            }
        }
        return 0;
    }
}
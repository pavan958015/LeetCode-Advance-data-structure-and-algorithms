class Solution {
    static class Pair{
        String str;
        int step;
        Pair(String str,int step){
            this.str=str;
            this.step=step;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        set.remove(beginWord);

        while(!q.isEmpty()){
            Pair cur=q.poll();
            String word=cur.str;
            int step=cur.step;

            if(word.equals(endWord)) return step;

            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char arr[]=word.toCharArray();
                    arr[i]=ch;
                    String newS=new String(arr);
                    if(set.contains(newS)==true){
                        set.remove(newS);
                        q.add(new Pair(newS,step+1));
                    }
                }
            }

        }
        return 0;
    }
}
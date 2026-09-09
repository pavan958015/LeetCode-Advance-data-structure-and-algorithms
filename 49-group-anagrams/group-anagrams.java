class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // make Map for storing all the anangrams
        Map<String,List<String>> map=new HashMap<>();

        for(String w:strs){
            char[] chars=w.toCharArray();
            Arrays.sort(chars);
            String str=new String(chars);

            if(!map.containsKey(str)){
                map.put(str,new ArrayList<>());
            }
            map.get(str).add(w);
        }
        return new ArrayList<>(map.values());
    }
}
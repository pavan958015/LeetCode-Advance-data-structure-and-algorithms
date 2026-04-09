class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        int n=responses.size();

        List<Set<String>> response=new ArrayList<>();

        for(int i=0; i<responses.size(); i++)
        {
            Set<String> set = new HashSet<>(responses.get(i));
            response.add(set);
        }
        
        Map<String,Integer> map=new HashMap<>();
        for(Set<String> userSet : response)
        {
            for(String s : userSet)
            {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        int max=0;
        for (Map.Entry<String, Integer> m : map.entrySet()){
            String cur=m.getKey();
            int c=m.getValue();

            max=Math.max(max,c);
        }
        List<String> ans=new ArrayList<>();
         for (Map.Entry<String, Integer> m : map.entrySet()){
            if(m.getValue()==max) ans.add(m.getKey());
        }
        Collections.sort(ans);
        return ans.get(0);
    }
}
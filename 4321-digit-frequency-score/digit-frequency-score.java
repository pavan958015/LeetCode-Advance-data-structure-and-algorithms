class Solution {
    public int digitFrequencyScore(int n) {
        Map<Integer,Integer> map=new HashMap<>();

        while(n>0){
            int d=n%10;
            map.put(d,map.getOrDefault(d,0)+1);
            n/=10;
        }  
        int sum=0;
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            int key=m.getKey();
            int val=m.getValue();
            sum+=key*val;
        }
        return sum;
    }
}
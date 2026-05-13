class Solution {
    public int totalFruit(int[] fruits) {
        int max=Integer.MIN_VALUE;
        Map<Integer,Integer> map=new HashMap<>();

        int i=0;    int j=0;
        int n=fruits.length;
        
        while(j<n){
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
            while(map.size()>=3){
                map.put(fruits[i],map.get(fruits[i])-1);
                if(map.get(fruits[i])==0) map.remove(fruits[i]);
                i++;
            }
            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}
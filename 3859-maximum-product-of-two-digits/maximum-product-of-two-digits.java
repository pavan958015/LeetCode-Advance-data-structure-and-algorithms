class Solution {
    public int maxProduct(int n) {

        if(n<10) return n;

        List<Integer> list=new ArrayList<>();

        while(n>0){
            int d=n%10;
            list.add(d);
            n/=10;
        }

        Collections.sort(list);
        return list.get(list.size()-1)*list.get(list.size()-2);
    }
}
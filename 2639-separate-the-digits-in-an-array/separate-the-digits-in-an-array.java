class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list=new ArrayList<>();

        for(int x:nums){
            String s=Integer.toString(x);

            for(char c:s.toCharArray()){
                list.add(c-'0');
            }
        }
        int res[]=new int[list.size()];

        for(int i=0;i<res.length;i++){
            res[i]=list.get(i);
        }   
        return res;
    }
}
class Solution {
    // public boolean canArrange(int[] arr, int k) {

    //     int left=0; int right=arr.length-1;
    //     while(left<right){
    //         int sum=Math.abs(arr[left]+arr[right]);
    //         // System.out.print(sum+" ");
    //         if(sum%k!=0) return false;
    //         left++;
    //         right--;
    //     }   
    //     return true;
    // }
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer>mp = new HashMap<>();
        for(int x : arr){
            int key = (x%k+k)%k;
            mp.put( key, mp.getOrDefault(key , 0)+1);
        }

        for(Map.Entry<Integer,Integer> m:mp.entrySet()){
            int key=m.getKey();
            int val=m.getValue();

            if(key==0){
                if(val%2 !=0) return false;
            }else{
                int cp = k - key;
                int cval = mp.getOrDefault(cp,0);

                if(val != cval) return false;
            }
        }
        return true;
    }
}
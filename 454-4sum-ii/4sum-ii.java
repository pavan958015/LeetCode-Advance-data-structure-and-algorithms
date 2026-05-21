class Solution {
    // public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    //     int count=0;
    //     int n=nums1.length;
    //     for(int i=0;i<n;i++){
    //         for(int j=0;j<n;j++){
    //             for(int k=0;k<n;k++){
    //                 for(int l=0;l<n;l++){
    //                     int sum=nums1[i]+nums2[j]+nums3[k]+nums4[l];
    //                     if(sum==0) count++;
    //                 }
    //             }
    //         }
    //     }
    //     return count;
    // }

    // public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
    //     Map<Integer,Integer> map=new HashMap<>();
    //     int count=0; int n=nums1.length;
    //     for(int i=0;i<n;i++)
    //         map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);

    //     for(int j:nums2){
    //         for(int k:nums3){
    //             for(int l:nums4){
    //                 int sum=map.getOrDefault(-(j+k+l),0);
    //                 count+=sum;
    //             }
    //         }
    //     }
    //     return count;
    // }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        Map<Integer,Integer> map=new HashMap<>();
        int n=nums1.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map.put(nums1[i]+nums2[j],map.getOrDefault(nums1[i]+nums2[j],0)+1);
            }
        }

        int count=0;
        for(int k=0;k<n;k++){
            for(int l=0;l<n;l++){
                int sum=map.getOrDefault(-(nums3[k]+nums4[l]),0);
                count+=sum;
            }
        }
        return count;
    }
}
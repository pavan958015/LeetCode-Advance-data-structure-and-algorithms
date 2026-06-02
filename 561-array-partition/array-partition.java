class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int res=0;
        for(int i=0;i<n;i+=2){
            res+=nums[i];
        }
        return res;
    }
}



// first sort;
// I know that if I make pares in i and i+2 then I can find maximized sum
// [1,4,3,2]
// .    .
// [1,2,3,4]            4


// [6,2,6,5,1,2]
//  .   .   .
// [1,2,2,5,6,6]    1 2 6->9
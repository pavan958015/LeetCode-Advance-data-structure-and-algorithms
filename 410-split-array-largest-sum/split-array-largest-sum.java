class Solution {
    public int splitArray(int[] nums, int k) {
        return find(nums,k);
    }

    public static int total(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    public static int maxElement(int arr[]){
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(max<=arr[i]){
                max=arr[i];
            }
        }
        return max;
    }

    public static int find(int arr[], int k) {
        int low = maxElement(arr);
        int high = total(arr);
        int ans = high;
        while (low <= high) {

            int mid = low + (high - low) / 2;
            boolean fit = check(arr, mid, k);
            if (fit) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean check(int arr[], int mid, int k) {
        int sum = 0;
        int box = 1;
        for (int w : arr) {
            if (w + sum <= mid) {
                sum += w;
            } else {
                box++;
                sum = w;
                if (box > k) {
                    return false;
                }
            }
        }
        return true;
    }

}
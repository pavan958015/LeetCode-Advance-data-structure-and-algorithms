class Solution {
    public boolean canReach(int[] arr, int start) {

        // out of bounds
        if(start < 0 || start >= arr.length)
            return false;

        // already visited
        if(arr[start] < 0)
            return false;

        // reached zero
        if(arr[start] == 0)
            return true;

        int jump = arr[start];

        // mark visited
        arr[start] = -arr[start];

        return canReach(arr, start + jump) ||
               canReach(arr, start - jump);
    }
}
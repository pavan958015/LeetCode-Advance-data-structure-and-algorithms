class NumArray {
    static int seg[];
    static int arr[];
    static int n;

    public NumArray(int[] nums) {
        arr = nums;
        seg = new int[4 * nums.length];
        n = nums.length;

        build(1, 0, n - 1);
    }

    public static void build(int node, int start, int end) {
        if (start == end) {
            seg[node] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        build(2 * node, start, mid);
        build(2 * node + 1, mid + 1, end);

        seg[node] = seg[2 * node] + seg[2 * node + 1];

    }

    public static void updateTree(int node, int start, int end, int idx, int val) {
        if (start == idx && idx == end) {
            seg[node] = val;
            return;
        }
        int mid = (start + end) / 2;
        if (mid >= idx)
            updateTree(2 * node, start, mid, idx, val);
        else
            updateTree(2 * node + 1, mid + 1, end, idx, val);

        seg[node] = seg[2 * node] + seg[2 * node + 1];

    }

    public static int query(int node, int start, int end, int left, int right) {
        // no overlap
        if (right < start || end < left)
            return 0;

        // complete overlap
        if (left <= start && end <= right)
            return seg[node];

        int mid = (start + end) / 2;

        int left_sum = query(2 * node, start, mid, left, right);
        int right_sum = query(2 * node + 1, mid + 1, end, left, right);

        return left_sum + right_sum;
    }

    public void update(int index, int val) {
        updateTree(1, 0, n - 1, index, val);
    }

    public int sumRange(int left, int right) {
        return query(1, 0, n - 1, left, right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
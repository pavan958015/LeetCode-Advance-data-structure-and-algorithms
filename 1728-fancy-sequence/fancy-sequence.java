import java.util.*;

class Fancy {

    int MOD = 1000000007;
    int size = 100000;
    long[] tree = new long[4 * size];
    long[] lazyMul = new long[4 * size];
    long[] lazyAdd = new long[4 * size];

    int n = 0;

    public Fancy() {
        Arrays.fill(lazyMul, 1);
    }

    private void push(int node, int start, int end) {
        if (lazyMul[node] != 1 || lazyAdd[node] != 0) {

            tree[node] = (tree[node] * lazyMul[node] % MOD +
                          (end - start + 1) * lazyAdd[node] % MOD) % MOD;

            if (start != end) {
                int left = node * 2;
                int right = node * 2 + 1;

                lazyMul[left] = lazyMul[left] * lazyMul[node] % MOD;
                lazyMul[right] = lazyMul[right] * lazyMul[node] % MOD;

                lazyAdd[left] = (lazyAdd[left] * lazyMul[node] + lazyAdd[node]) % MOD;
                lazyAdd[right] = (lazyAdd[right] * lazyMul[node] + lazyAdd[node]) % MOD;
            }

            lazyMul[node] = 1;
            lazyAdd[node] = 0;
        }
    }

    private void update(int node, int start, int end, int l, int r, long mul, long add) {

        push(node, start, end);

        if (r < start || end < l) return;

        if (l <= start && end <= r) {
            lazyMul[node] = mul;
            lazyAdd[node] = add;
            push(node, start, end);
            return;
        }

        int mid = (start + end) / 2;

        update(node * 2, start, mid, l, r, mul, add);
        update(node * 2 + 1, mid + 1, end, l, r, mul, add);

        tree[node] = (tree[node * 2] + tree[node * 2 + 1]) % MOD;
    }

    private long query(int node, int start, int end, int idx) {

        push(node, start, end);

        if (start == end) return tree[node];

        int mid = (start + end) / 2;

        if (idx <= mid)
            return query(node * 2, start, mid, idx);
        else
            return query(node * 2 + 1, mid + 1, end, idx);
    }

    public void append(int val) {
        update(1, 0, size - 1, n, n, 1, val);
        n++;
    }

    public void addAll(int inc) {
        update(1, 0, size - 1, 0, n - 1, 1, inc);
    }

    public void multAll(int m) {
        update(1, 0, size - 1, 0, n - 1, m, 0);
    }

    public int getIndex(int idx) {
        if (idx >= n) return -1;
        return (int) query(1, 0, size - 1, idx);
    }
}
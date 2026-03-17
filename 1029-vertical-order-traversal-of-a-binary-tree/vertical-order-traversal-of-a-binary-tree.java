class Solution {
    Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();

    public void dfs(TreeNode root, int row, int col) {
        if (root == null) return;

        
        map.putIfAbsent(col, new TreeMap<>());
        
        map.get(col).putIfAbsent(row, new ArrayList<>());
        
        map.get(col).get(row).add(root.val);

        dfs(root.left, row + 1, col - 1);
        dfs(root.right, row + 1, col + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);

        List<List<Integer>> ans = new ArrayList<>();

        for(int col:map.keySet()){
            List<Integer> cols=new ArrayList<>();
            for(int row:map.get(col).keySet()){
                List<Integer> values=map.get(col).get(row);
                Collections.sort(values);
                cols.addAll(values);
            }
            ans.add(cols);
        }
        return ans;
    }
}
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;

        return dfs(node);
    }
    static HashMap<Node,Node > hp=new HashMap<>();
    public static Node dfs(Node node){
        // if visited;
        if(hp.containsKey(node)) return hp.get(node);

        Node cur=new Node(node.val);
        hp.put(node,cur);

        // find neighbors
        for(Node neighbor:node.neighbors){
            cur.neighbors.add(dfs(neighbor));
        }
        return cur;
    }
}
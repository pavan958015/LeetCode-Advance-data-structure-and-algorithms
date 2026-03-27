class Solution {
    public static void dfs(int source,int destination,int[][]graph,List<List<Integer>>ans,List<Integer>temp){
        temp.add(source);
        if(source==destination){
            ans.add(new ArrayList<>(temp));
        }
        for(int x:graph[source]){
            dfs(x,destination,graph,ans,temp);
        }
        temp.remove(temp.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> temp=new ArrayList<>(); 
        dfs(0,graph.length-1,graph,ans,temp);
        return ans;
    }

}
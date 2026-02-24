class Solution {
    static int component;

    public static int find(int node, int[] par) {
        if (par[node] == node)
            return node;
        return par[node] = find(par[node], par);
    }

    public static void unionBySize(int u, int v, int[] par, int[] size) {
        int ulp_u = find(u, par);
        int ulp_v = find(v, par);

        if (ulp_u == ulp_v) {
            return;
        }
        if (size[ulp_u] > size[ulp_v]) {
            par[ulp_v] = ulp_u;
            size[ulp_u] += size[ulp_v];
            // maxi = Math.max(maxi, size[ulp_u]);
        } else {
            par[ulp_u] = ulp_v;
            size[ulp_v] += size[ulp_u];
            // maxi = Math.max(maxi, size[ulp_v]);
        }
        component--;
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        component = n;

        int par[] = new int[n + 1];
        int size[] = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            par[i] = i;
            size[i] = 1;
        }

        // get mail index

        HashMap<String,Integer> hp=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail=accounts.get(i).get(j);
                if(hp.containsKey(mail)==false){
                    hp.put(mail,i);
                }else{
                    unionBySize(i,hp.get(mail),par,size);   
                }
            }
        }

        // merge mail
        List<String>[] merge=new ArrayList[n];
        for(int i=0;i<n;i++){
            merge[i]=new ArrayList<>();
        }

        for(Map.Entry<String,Integer> it:hp.entrySet()){
            String mail=it.getKey();
            int node=find(it.getValue(),par);
            merge[node].add(mail);
        }
        List<List<String>> ans=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(merge[i].size()==0) continue;
            Collections.sort(merge[i]);
            List<String> temp=new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for(String it:merge[i]){
                temp.add(it);
            }
            ans.add(temp);
        }
return ans;
    }
}
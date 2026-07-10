class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas=0;
        int totalCost=0;

        for(int num:gas)
            totalGas+=num;
        for(int num:cost)
            totalCost+=num;

        // invalid condition
        if(totalGas<totalCost) return -1;

        int n=gas.length;

        int start=0;
        int total=0;

        // we sure that it will give answer because for invalid we already checked

        for(int i=0;i<n;i++){
            total+=gas[i]-cost[i];

            if(total<0){
                start=i+1;
                total=0;
            }
        }
        return start;
        
    }
}
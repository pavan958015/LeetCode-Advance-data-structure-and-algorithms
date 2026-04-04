class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // total gas
        int totalgas=0;
        for(int n:gas){
            totalgas+=n;
        }


        // total cost
        int totalcost=0;
        for(int n:cost){
            totalcost+=n;
        }
        // for -1 invalid case;
        if(totalgas<totalcost) return -1;


        int start=0;
        int curGas=0;

        for(int i=0;i<gas.length;i++){
            curGas+=gas[i]-cost[i];

            if(curGas<0){
                start=i+1;
                curGas=0;
            }
        }
        return start;

    }
}
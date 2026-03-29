class Solution {
    char[] arr;
    int index = 0;

    public int calculate(String s) {
        arr = s.toCharArray();
        return dfs();
    }

    private int dfs() {
        int sum = 0;
        int operator = 1;

        while (index < arr.length) {

            if (arr[index] == ' ') {
                index++;
                continue;
            }

            if (arr[index] == ')') {
                index++;
                break;
            }

            if (arr[index] == '+') {
                operator = 1;
            } 
            else if (arr[index] == '-') {
                operator = -1;
            } 
            else if (arr[index] == '(') {
                index++;
                int val = dfs();
                sum += operator * val;
                continue; 
            } 
            else if (Character.isDigit(arr[index])) {
                int num = 0;
                while (index < arr.length && Character.isDigit(arr[index])) {
                    num = num * 10 + (arr[index] - '0');
                    index++;
                }
                sum += operator * num;
                continue; 
            }

            index++;
        }

        return sum;
    }
}
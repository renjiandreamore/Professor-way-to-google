/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/gas-station
@Language: Java
@Datetime: 16-11-06 02:44
*/

public class Solution {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        if(gas == null || gas.length == 0 || cost == null || cost.length == 0){
            return -1;
        }
        
        int sum = 0;
        int total = 0;
        int position = -1;
        
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if(sum < 0){
                sum = 0;
                position = i;
            }
        }
        
        return total >= 0 ? position + 1 : -1;
    }
}
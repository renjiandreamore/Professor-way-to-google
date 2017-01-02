/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/digit-counts
@Language: Java
@Datetime: 16-10-22 23:56
*/

class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        if(n <10) return 1;
        int count = 0;
        
        for(int i = 0; i <= n; i++){
            count += singleCount(i, k);
        }
        return count;
    }
    
    public int singleCount(int num, int target){
        if(num == 0 && target == 0){
            return 1;
        }
        int count = 0;
        while(num > 0){
            if(num%10 == target){
                count ++;
            }
            num = num / 10;
        }
        return count;
    }
};

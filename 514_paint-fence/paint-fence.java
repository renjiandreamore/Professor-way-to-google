/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/paint-fence
@Language: Java
@Datetime: 16-12-22 18:34
*/

public class Solution {
    /**
     * @param n non-negative integer, n posts
     * @param k non-negative integer, k colors
     * @return an integer, the total number of ways
     */
    public int numWays(int n, int k) {
        // Write your code here
        if(n == 1) return k;
        
        int Same = k;
        int Diff = k*(k-1);
        
        for(int i = 2; i < n; i++){
            int tmp = (k-1) *(Same + Diff);
            Same = Diff;
            Diff = tmp;
        }
        
        return Same + Diff;
    }
}
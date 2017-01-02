/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/gray-code
@Language: Java
@Datetime: 16-12-15 00:29
*/

public class Solution {
    /**
     * @param n a number
     * @return Gray code
     */
    public ArrayList<Integer> grayCode(int n) {
        // Write your code here
        ArrayList<Integer> res = new ArrayList<>();
        if(n == 0){
            res.add(0);
            return res;
        }
        
        res = grayCode(n-1);
        
        int size = res.size();
        for(int i = size - 1; i >= 0; i--){
            int num = res.get(i);
            num += 1 << (n-1);
            res.add(num);
        }
        
        return res;
    }
}
/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/singleton
@Language: Java
@Datetime: 16-11-08 04:35
*/

class Solution {
    /**
     * @return: The same instance of this class every time
     */
    public static Solution instance = null;
    public static Solution getInstance() {
        // write your code here
        if(instance == null){
            instance = new Solution();
        }
        return instance;
    }
};
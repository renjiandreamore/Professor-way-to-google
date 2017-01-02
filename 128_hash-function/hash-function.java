/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/hash-function
@Language: Java
@Datetime: 16-09-13 23:56
*/

class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        long answer = 0;
        for(int i =0; i < key.length; i++){
            answer = (answer * 33 + (int)key[i]) % HASH_SIZE;
        }
        return (int)answer;
    }
};
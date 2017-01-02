/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/single-number-ii
@Language: Java
@Datetime: 16-11-01 02:53
*/

public class Solution {
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
    public int singleNumberII(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        // Map<Integer, Integer> map = new HashMap<>();
        // for(int i = 0; i < A.length; i++){
        //     if(!map.containsKey(A[i])){
        //         map.put(A[i], 1);
        //     }else{
        //         map.put(A[i], map.get(A[i]) + 1);
        //     }
        // }
        
        // for(int key : map.keySet() ){
        //     if(map.get(key) == 1) return key;
        // }
        
        // return -1;
        
        //如果我们把 第 ith  个位置上所有数字的和对3取余，那么只会有两个结果 0 或 1 (根据题意，3个0或3个1相加余数都为0).  因此取余的结果就是那个 “Single Number”.
        int result = 0;
        int[] bit= new int[32];
        for(int i = 0; i < 32; i++){
            for(int j = 0; j < A.length; j++){
                bit[i] += A[j] >> i & 1; // 取各个位置上最后一个为1还是0
                bit[i] %= 3;
            }
            
            result = result | bit[i] << i; //把余数后面补i个0表示最终结果这个位置上是1还是0, |=相当于各个位置求和
        }
        return result;
        
    }
}
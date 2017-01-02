/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/single-number-iii
@Language: Java
@Datetime: 16-11-01 03:24
*/

public class Solution {
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if(A == null || A.length == 0){
            return res;
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
        //     if(map.get(key) == 1) res.add(key);
        // }
        
        // return res;
        
        int xor = 0;
        for(int i = 0; i < A.length; i++){
            xor ^= A[i];  //find the two single's xor
        }
        
        int position_for_one = xor - ((xor - 1) & xor);
        
        int xor0 = 0, xor1 = 0;
        for(int i = 0; i < A.length; i++){
            if( (A[i] & position_for_one) == 0){
                xor0 ^= A[i];
            }else{
                xor1 ^= A[i];
            }
        }
        res.add(xor0);
        res.add(xor1);
        return res;
        
    }
}
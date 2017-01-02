/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/product-of-array-exclude-itself
@Language: Java
@Datetime: 16-10-24 00:32
*/

public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        ArrayList<Long> res = new ArrayList<>();
        int len = A.size();
        long[] suffixProduct = new long[len];
        suffixProduct[len - 1] = A.get(len -1);
        for(int i = len-2; i >= 0; i --){
            suffixProduct[i] = A.get(i);
            suffixProduct[i] *= suffixProduct[i+1];
        }
        
        long now = 1;
        long prefixProduct = 1;
        
        for (int i = 0; i < len; i ++) {
            //now = prefixProduct;
            if(i + 1 < len){
                res.add(prefixProduct * suffixProduct[i+1]);
            }else{
                res.add(prefixProduct);
            }
            //now = A.get(i);
            prefixProduct = A.get(i) * prefixProduct;
        }
        
        return res;
    }
}

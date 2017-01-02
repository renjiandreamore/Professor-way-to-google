/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/cosine-similarity
@Language: Java
@Datetime: 16-12-17 21:16
*/

class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: Cosine similarity.
     */
    public double cosineSimilarity(int[] A, int[] B) {
        // write your code here
        int dividor = 0;
        for(int i = 0; i < A.length; i++){
            dividor += A[i] * B[i];
        }
        
        int d1 = 0;
        for(int i = 0; i < A.length; i++){
            d1 += A[i]*A[i];
        }
        
        if(d1 == 0) return 2.0000;
        
        int d2 = 0;
        for(int i = 0; i < B.length; i++){
            d2 += B[i]*B[i];
        }
        
        if(d2 == 0) return 2.0000;
        
        return dividor/ Math.sqrt(d1) / Math.sqrt(d2);
    }
}

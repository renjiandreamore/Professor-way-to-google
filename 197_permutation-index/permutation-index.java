/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/permutation-index
@Language: Java
@Datetime: 16-11-11 13:12
*/

public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        // Write your code here
        if(A == null || A.length == 1){
            return (long) 0;
        }
        
        int n = A.length;
        
        long res = 0;
        
        long fact = 1;
        // for(int i = 1; i < n; i++){
        //     fact *= i;
        // }
        
        long divider = n-1;
        
        // for(int i = 0; i < A.length; i++){
        //     long count = 0; // 第几大
        //     for(int j = i; j < A.length; j++){
        //         if(A[i] >= A[j]){    //eg: [3,4,1,2] 3是第几大 
        //             count++;
        //         }
        //     }
            
        //     res += (count-1) * fact;
        //     if(divider != 0){
        //         fact = fact / divider;
        //         divider--;
        //     }
        // }
        
        for(int i = n - 1; i >= 0; i--){
            int count = 0;
            for(int j = i + 1; j < n; j++){
                if(A[i] > A[j]){
                    count ++;
                }
            }
            
            res += count * fact;
            fact *= (n-i);
        }
        
        res = res + 1;
        
        return res;
    }
}
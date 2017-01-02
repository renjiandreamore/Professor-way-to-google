/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/remove-element
@Language: Java
@Datetime: 16-11-01 23:20
*/

public class Solution {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        
        int n = A.length;
        int index = 0;
        for(int i = 0; i < n;){
            if(A[i] != elem){
                A[index] = A[i];
                index++ ;
                i++;
            }else{
                i++;
            }
        }
        return index ;
    }
}

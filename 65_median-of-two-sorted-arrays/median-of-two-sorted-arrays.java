/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/median-of-two-sorted-arrays
@Language: Java
@Datetime: 16-03-14 18:36
*/

class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
       
		//1st merge
		int length = A.length + B.length;
		if(length % 2 == 1){
			return findKthNumber(A, 0, B, 0, length/2 + 1);
		}else{
			return (findKthNumber(A, 0, B, 0, length/2) + findKthNumber(A, 0, B, 0, length/2 + 1))/2.0;
		}
		
	}
	
	public int findKthNumber(int[] A, int A_start, int[]B, int B_start, int k){
		if(A_start >= A.length){
			return B[B_start + k -1];
		}
		if(B_start >= B.length){
			return A[A_start + k -1];
		}
		
		if(k == 1){
			return Math.min(A[A_start], B[B_start]);
		}
		
		int A_key = A_start + k/2 - 1 < A.length ? A[A_start + k/2 - 1] : Integer.MAX_VALUE;
		int B_key = B_start + k/2 - 1 < B.length ? B[B_start + k/2 - 1] : Integer.MAX_VALUE;
		
		if(A_key < B_key){
			return findKthNumber(A, A_start + k/2, B, B_start, k - k/2);
		}else {
			return findKthNumber(A, A_start, B, B_start + k/2, k - k/2);
		}
	
    }
}

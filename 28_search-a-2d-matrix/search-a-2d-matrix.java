/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/search-a-2d-matrix
@Language: Java
@Datetime: 16-02-29 05:57
*/

public class Solution {
	/**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
    	if(matrix.length == 0 || matrix == null || matrix[0].length == 0 || matrix[0] == null){
    		return false;
    	}
    	
    	int row = matrix.length;
    	int col = matrix[0].length;
    	
    	int start = 0;
    	int end = row * col - 1;
    	while(start + 1 < end){
    		int mid = start + (end - start)/2;
    		int result = matrix[mid/col][mid%col];
    		if(result == target){
    			end = mid;
    		}else if(result < target){
    			start = mid;
    		}else {
    			end = mid;
    		}
    	}
    	if(matrix[start/col][start%col] == target){
    		return true;
    	}else if(matrix[end/col][end%col] == target){
    		return true;
    	}
    	return false;
    }
}
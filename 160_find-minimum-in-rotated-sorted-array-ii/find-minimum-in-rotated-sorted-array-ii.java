/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/find-minimum-in-rotated-sorted-array-ii
@Language: Java
@Datetime: 16-10-01 22:06
*/

public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if(num == null || num.length == 0){
            return -1;
        }
        
        int start = 0, end = num.length - 1;
        int target = num[num.length - 1];
        
        while(start + 1 < end){
            int mid = start + ( end - start )/2; 
            if(num[mid] > target){
                start = mid;
            }else if(num[mid] == target){
                end --;
                target = num[end];
            }
            else{
                end = mid;
            }
        }
        
        if(num[start] <= num[end]){
            return num[start];
        }else{
            return num[end];
        }
    }
}
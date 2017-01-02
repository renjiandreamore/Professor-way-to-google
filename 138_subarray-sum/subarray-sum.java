/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/subarray-sum
@Language: Java
@Datetime: 16-03-29 03:06
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
       ArrayList<Integer> res = new ArrayList<Integer>();
       HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
       
       hash.put(0, -1);
       
       int sum = 0;
       for(int i =0; i<nums.length; i++){
           sum += nums[i];
           
           
           if(hash.containsKey(sum)){
               res.add(hash.get(sum)+1);
               res.add(i);
               return res;
           }
           hash.put(sum, i);
       }
       return res;
    }
}
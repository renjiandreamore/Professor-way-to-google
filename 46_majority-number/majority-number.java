/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/majority-number
@Language: Java
@Datetime: 16-10-22 23:23
*/

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(!map.containsKey(num)){
                map.put(num, 1);
            }else{
                int count = map.get(num);
                map.put(num, count+1);
            }
        }
        
        for(int key : map.keySet()){
            if(map.get(key) > nums.size() / 2){
                return key;
            }
        }
        
        return -1;
    }
}
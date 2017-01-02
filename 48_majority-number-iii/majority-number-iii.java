/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/majority-number-iii
@Language: Java
@Datetime: 16-10-22 23:25
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
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
            if(map.get(key) > nums.size() / k){
                return key;
            }
        }
        
        return -1;
    }
}

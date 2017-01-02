/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/two-sum
@Language: Java
@Datetime: 16-03-30 17:48
*/

public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for(int i = 0; i<numbers.length; i++){
    		if(map.containsKey(numbers[i])){
    			int[] result = new int[]{map.get(numbers[i])+1, i + 1};
    			return result;
    		}
    		
    		map.put(target - numbers[i], i);
    		
    	}
    	int[] result = {};
    	return result;
    }
}
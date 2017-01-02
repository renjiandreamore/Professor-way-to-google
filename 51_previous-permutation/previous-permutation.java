/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/previous-permutation
@Language: Java
@Datetime: 16-10-24 01:38
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		// write your code
		// oppsite of nexPermutation
		//ArrayList<Integer> res = new ArrayList<>();
		
		if(nums == null || nums.size()== 0 ){
		    return nums;
		}
		
		int l = nums.size();
		
		int index = -1;
		for(int i = l - 2; i >= 0; i--){
		    if(nums.get(i+1) < nums.get(i)){
		        index = i;
		        break;
		    }
		}
		
		if(index == -1){
		    return reverse(nums, 0, l - 1);
		}
		
		nums = reverse(nums, index + 1, l - 1);
		
		int smaller = l - 1;
		for(int i = index + 1; i < l; i++){
		    if(nums.get(i) < nums.get(index)){
		        smaller = i;
		        break;
		    }
		}
		
		int tmp = nums.get(index);
		nums.set(index, nums.get(smaller));//  = nums.get(smaller);
		nums.set(smaller, tmp) ; //= tmp;
		
		return nums;
    }
    
    public ArrayList<Integer> reverse(ArrayList<Integer> nums, int a, int b){
        for(int i = a, j = b; i < j; i++, j--){
            int tmp = nums.get(i);
            nums.set(i, nums.get(j));// = nums.get(j);
            nums.set(j, tmp); // = tmp;
        }
        
        return nums;
    }
}

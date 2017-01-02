```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/partition-array
@Language: Markdown
@Datetime: 16-04-02 20:03
```

public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    if(nums.length == 0 || nums == null){
	        return 0;
	    }
	    int res = 0;
	    
	    Arrays.sort(nums);
	    for(int i = 0; i < nums.length; i++){
	        if(nums[i] >= k){
	            res = i;
	            //break;
	        }
	        if(nums[nums.length-1] < k){
	            res = nums.length;
	        }
	        
	    }
	    
	    
	    return res;
	    
    }
}






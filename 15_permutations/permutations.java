/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/permutations
@Language: Java
@Datetime: 16-12-18 18:27
*/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null) return res;
        if(nums.length == 0) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        
        List<Integer> path = new ArrayList<>();
        helper(res, path, nums);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> path, int[] nums){
        if(path.size() == nums.length){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        
        //int pre = -1;
        for(int i = 0; i < nums.length; i++){
            if(path.contains(nums[i])) continue;
            // if(pre != -1 && nums[i] == nums[pre]){
            //     continue;
            // }
            
            path.add(nums[i]);
            helper(res, path, nums);
            //pre = i;
            path.remove(path.size()-1);
        }
    }
}

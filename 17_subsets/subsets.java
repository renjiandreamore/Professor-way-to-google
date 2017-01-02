/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/subsets
@Language: Java
@Datetime: 16-02-28 00:19
*/



class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(nums);
        
        ArrayList<Integer> path = new ArrayList<Integer>();
        dfs(nums, 0, path, result);
        
        return result;
    }    
        
           
        
        
    public void dfs(int[] nums, int index, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result ){
        result.add(new ArrayList<Integer>(path));
            
        for(int i = index; i < nums.length; i++){
            path.add(nums[i]);
            dfs(nums, i + 1, path, result);
            path.remove(path.size() -1);
        }
    }
}

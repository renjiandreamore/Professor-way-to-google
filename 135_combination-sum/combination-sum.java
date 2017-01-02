/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/combination-sum
@Language: Java
@Datetime: 16-11-03 04:02
*/

public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0){
            return res;
        }
        
        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        helper(res, path, candidates, target, 0);
        return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> path, int[]candidates, int target, int index){
        if(target == 0){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        
        int prev = -1;

        for(int i = index; i < candidates.length; i++){
            if(candidates[i] > target){
                break;
            }
            // if(prev != -1 && candidates[i] == prev){
            //     continue;
            // }
            if(candidates[i] != prev){
                path.add(candidates[i]);
            prev = candidates[i];
            helper(res, path, candidates, target - candidates[i], i);
            path.remove(path.size()-1);
            }
            
        }
        
        
    }
}
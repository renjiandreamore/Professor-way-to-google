/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/combination-sum-ii
@Language: Java
@Datetime: 16-11-03 04:00
*/

public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
         List<List<Integer>> res = new ArrayList<>();
        if(num == null || num.length == 0){
            return res;
        }
        
        Arrays.sort(num);
        List<Integer> path = new ArrayList<>();
        helper(res, path, num, target, 0);
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
            if(prev != -1 && candidates[i] == prev) continue;
            
            if(candidates[i] != prev){
                path.add(candidates[i]);
            prev = candidates[i];
            helper(res, path, candidates, target - candidates[i], i+1);
            path.remove(path.size()-1);
            }
            
        }
    }
}
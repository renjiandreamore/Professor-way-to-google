```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/combination-sum
@Language: Markdown
@Datetime: 16-11-03 04:02
```

 
 public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0){
            return res;
        }
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(res, path, candidates, target, 0);
        return res;
    }
    
    void helper(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int index){
        if( target ==  0){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        
        int prev = -1; //prev其实表示被path.remove的那个数;
        for(int i = index; i < candidates.length; i++){
            if(candidates[i] > target){
                break;
            }
            if(prev != -1 && prev == candidates[i]){
                continue;
            }
            
            path.add(candidates[i]);
            helper(res, path, candidates, target - candidates[i], i);
            prev = candidates[i];
            path.remove(path.size()-1);
        }
    }
}
/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/combinations
@Language: Java
@Datetime: 16-11-03 04:29
*/

public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
		// write your code here
		List<List<Integer>> res = new ArrayList<>();
		
		if(n <= 0 || k > n){
		    return res;
		}
		
		
		List<Integer> path = new ArrayList<>();
		helper(res, path, n, k, 1);
		return res;
    }
    
    public void helper(List<List<Integer>> res, List<Integer> path, int n, int k, int index){
        
        //if( index > n) return;
        
        if(path.size()==k){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        
        for(int i = index; i<= n; i++){
            path.add(i);
            helper(res, path, n, k, i + 1);
            path.remove(path.size()-1);
        }
    }
}
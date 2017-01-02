/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/subsets-ii
@Language: Java
@Datetime: 16-09-27 04:27
*/

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(S == null){
            return res;
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        Collections.sort(S);
        helper(res, path, S, 0);
        return res;
    }
    
    void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, ArrayList<Integer> S, int index){
        res.add(new ArrayList<Integer>(path));
        // if(index == S.size()){
        //     res.add(new ArrayList<Integer>(path));
        //     return;
        // }
        
        for(int i = index; i < S.size(); i++){
            if(i != index && S.get(i) == S.get(i-1)){
                continue;
            }
            path.add(S.get(i));
            helper(res, path, S, i+1);
            path.remove(path.size()-1);
        }
    }
}

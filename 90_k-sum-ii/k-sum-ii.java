/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/k-sum-ii
@Language: Java
@Datetime: 16-10-11 19:41
*/

public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(A == null || A.length == 0){
            return res;
        }
        
        ArrayList<Integer> path = new ArrayList<>();
        dfs(A, k, target, res, path, A.length - 1);
        return res;
    }
    
    public void dfs(int[] A, int k, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, int index){
        if(k == 0 && target == 0){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        
        if(k < 0 || target < 0 || index < 0){
            return;
        }
        
        /**
         * 跟背包相似， dfs1 表示不要最后一个数4， 他之前的结果
         *              dfs2 表示算上最后一个数4， 把它加入到path，然后之前
         *              减去4以后k-1个数可以得到的结果
         **/
        dfs(A, k, target, res, path, index - 1);       
        path.add(A[index]);
        dfs(A, k-1, target - A[index],res, path, index - 1 );
        path.remove(path.size()-1);
    }
}
/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/unique-binary-search-trees-ii
@Language: Java
@Datetime: 16-12-01 19:47
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @paramn n: An integer
     * @return: A list of root
     */
    public List<TreeNode> generateTrees(int n) {
        // write your code here
        
        List<TreeNode> res = new ArrayList<>();
        if(n < 0) return res;
        
        return generate(1, n);
    }
    
    public List<TreeNode> generate(int start, int end){
        List<TreeNode> res = new ArrayList<>();
        if(start > end){
            res.add(null);
            return res;
        }
        
        // if(start == end){
        //     TreeNode node = new TreeNode(start);
        //     res.add(node);
        //     return res;
        // }
        
        for(int i = start; i <= end; i++){
            List<TreeNode> left = generate(start, i - 1);
            List<TreeNode> right = generate(i + 1, end);
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        
        return res;
    }
}
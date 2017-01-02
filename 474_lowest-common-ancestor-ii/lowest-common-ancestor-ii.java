/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/lowest-common-ancestor-ii
@Language: Java
@Datetime: 16-10-01 22:37
*/

/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class Solution {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        // Write your code here   
        ArrayList<ParentTreeNode> pathA = getPath2root(A, root);
        ArrayList<ParentTreeNode> pathB = getPath2root(B, root);
        
        int indexA = pathA.size()-1;
        int indexB = pathB.size()-1;
        
        ParentTreeNode node = null;
        while(indexA >= 0 && indexB >= 0){
            if(pathA.get(indexA) != pathB.get(indexB)){
                break;
            }
            node = pathA.get(indexA);
            indexA--;
            indexB--;
        }
        return node;
        
    }
    
    public ArrayList<ParentTreeNode> getPath2root(ParentTreeNode A, ParentTreeNode root){
        ArrayList<ParentTreeNode> res = new ArrayList<>();
        while(A != null){
            res.add(A);
            A= A.parent;
        }
        return res;
    }
}

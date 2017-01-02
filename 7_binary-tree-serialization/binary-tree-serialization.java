/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/binary-tree-serialization
@Language: Java
@Datetime: 16-08-21 17:31
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
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if(root == null){return "{}";}
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);

        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node == null) {
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }

        // while (queue.get(queue.size() - 1) == null) {
        //     queue.remove(queue.size() - 1);
        // }

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(queue.get(0).val);
        for (int i = 1; i < queue.size(); i++) {
            if (queue.get(i) == null) {
                sb.append(",#");
            } else {
                sb.append(",");
                sb.append(queue.get(i).val);
            }
        }
        sb.append("}");
        return sb.toString();
        
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
    	if(data.equals("{}")){
    		return null;
    	}
    	String[] string = data.substring(1,data.length()-1).split(",");
    	ArrayList<TreeNode> res = new ArrayList<TreeNode>();
    	
    	TreeNode root = new TreeNode(Integer.parseInt(string[0]));
    	
    	res.add(root);
    	int index = 0;
    	boolean isLeftNode = true;
    	
    	for(int i = 1; i < string.length; i++){
    		if(!string[i].equals("#")){
    			TreeNode node = new TreeNode(Integer.parseInt(string[i]));
    			if(isLeftNode){
    				res.get(index).left = node; 
    			}else{
    				res.get(index).right = node;
    			}
    			res.add(node);
    			
    		}
    		if(!isLeftNode){index++;}
    		isLeftNode = !isLeftNode;
    	}
    	return root;
    }
}

```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/search-range-in-binary-search-tree
@Language: Markdown
@Datetime: 16-10-03 21:48
```

ArrayList<Integer> res1 = new ArrayList<Integer>();
        ArrayList<Integer> res2 = new ArrayList<Integer>();
        
        Stack<TreeNode> st = new Stack<TreeNode>();
        
        if(root == null){
            return res1;
        }
        
        TreeNode curt = root;
        st.push(root);
        while(root!=null || !st.isEmpty()){
            while(curt!=null){
                st.push(curt);
                curt = curt.left;
            }
            TreeNode node = st.pop();
            res1.add(node.val);
            curt = node.right;
        }
        
        int k = 0, m=0;
        for(int i = 0; i < res1.size(); i++){
            if(res1.get(i) >= k1){
                k = i;
                break;
            }
        }
        for(int j = res1.size()-1; j > 0; j--){
            if(res1.get(j) <= k2){
                m = j;
                break;
            }
        }
        
        for(int s = 0; s < m - k + 1; s++){
            res2.add( res1.get(s));
        }
        return res2;
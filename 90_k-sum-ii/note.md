```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/k-sum-ii
@Language: Markdown
@Datetime: 16-10-11 19:41
```

这道题死记硬背。
[1,2,3,4]

两个dfs调用，模拟了如下过程:
			path[1,]   不满足， 删  --- path[]
			path[2,],  -- path[2 ,1] , 不满足 ，删 --- path[2]--path[]
			path[3,], -- path[3,1] 不满足，删 --- path[3] --- path[3,2] 满足，， 加入 res  ---  
			删--path[3], ----path[]
			path[4,] -- .......
			
			
			public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    ArrayList<ArrayList<Integer>> res;
    
    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        res = new ArrayList<>();
        if(A == null || A.length == 0){
            return res;
        }
        ArrayList<Integer> path = new ArrayList<>();
        dfs(A, k, target, A.length - 1, path);
        return res;
    }
    
    
    public void dfs(int A[], int K, int target, int index, ArrayList<Integer> tans)
    {

        if(K == 0 && target == 0) {
            res.add(new ArrayList<Integer>(tans));
            return ;
        }
        if(K < 0 || target < 0 || index < 0)
            return ;
        dfs(A, K, target, index - 1, tans);
        tans.add(A[index]);
        dfs(A, K  - 1, target - A[index], index - 1, tans);
        tans.remove(tans.size() - 1);
        
    }
}
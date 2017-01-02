```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/permutations-ii
@Language: Markdown
@Datetime: 16-11-06 14:44
```


public class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
				ArrayList<List<Integer>> rst = new   ArrayList<List<Integer>>();
         if (nums == null || nums.length ==0){
              rst.add(new ArrayList<Integer>());
             return rst;
         }
         Arrays.sort(nums);
         ArrayList<Integer> list = new ArrayList<Integer>();
         int[] visited = new int[nums.length];
         for(int i = 0; i < nums.length; i++){
             visited[i] = 0;
         }
         helper(rst, list, nums,visited);
         return rst;
    }
    
    public void helper(ArrayList<List<Integer>> rst, ArrayList<Integer> list, int[] nums,int[] visited){
        if(list.size() == nums.length) {
            rst.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(visited[i] == 1 || (i!=0 && nums[i]==nums[i-1] && visited[i-1] == 0)){
                continue;
            }
            visited[i] = 1;
            list.add(nums[i]);      //加上nums[i]后，算他后面的全排列
            helper(rst, list, nums,visited);
            // 在list加入了nums[i]的基础上再调用helper，再往下算
            list.remove(list.size()-1); // 把加上的nums[i]抹了
            visited[i] = 0;
        }
        
    }
}
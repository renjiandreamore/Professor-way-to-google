```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/permutations
@Language: Markdown
@Datetime: 16-12-18 18:27
```

 ArrayList&lt;List&lt;Integer&gt;&gt; rst = new ArrayList&lt;List&lt;Integer&gt;&gt;();
         if (nums == null || nums.length ==0){
              rst.add(new ArrayList&lt;Integer&gt;());
             return rst;
         }

         ArrayList&lt;Integer&gt; list = new ArrayList&lt;Integer&gt;();
         helper(rst, list, nums);
         return rst;
    }
    
    public void helper(ArrayList&lt;List&lt;Integer&gt;&gt; rst, ArrayList&lt;Integer&gt; list, int[] nums){
        if(list.size() == nums.length) {
            rst.add(new ArrayList&lt;Integer&gt;(list));
            return;
        }
        
        for(int i = 0; i &lt; nums.length; i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);      //加上nums[i]后，算他后面的全排列
            helper(rst, list, nums); // 在list加入了nums[i]的基础上再调用helper，再往下算
            list.remove(list.size()-1); // 把加上的nums[i]抹了
        }
        
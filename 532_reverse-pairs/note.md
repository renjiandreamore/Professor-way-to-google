```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/reverse-pairs
@Language: Markdown
@Datetime: 16-12-07 19:12
```

if(A == null || A.length == 0) return 0;
        long count = 0;
        
        for(int i = 0; i < A.length; i++){
            for(int j = i + 1; j < A.length; j++){
                if(A[i] > A[j]) count++;
            }
        }
        
        return count;
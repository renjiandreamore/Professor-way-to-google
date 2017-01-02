```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/4sum
@Language: Markdown
@Datetime: 16-04-02 18:56
```

例如，对于给定的整数数组S=[1, 0, -1, 0, -2, 2] 和 target=0. 满足要求的四元组集合为：

(-1, 0, 0, 1)

(-2, -1, 1, 2)

(-2, 0, 0, 2)

sort:
[-2, -1, 0, 0, 1, 2]

 for(int i = 0; i < len-3; i++){
            if(i != 0 && numbers[i] == numbers[i-1]){
                continue;
            }
            for(int j = i + 1; j < len-2; j++){
                if(j != i + 1 && numbers[j] == numbers[j-1]){ //此处是i+1不是1
                    continue;
                }
第二个for是 for int j = i + 1， 不是 int j = 1；想了一个小时！！				

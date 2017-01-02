```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/jump-game-ii
@Language: Markdown
@Datetime: 16-08-19 22:54
```

f[i] 表示从0跳到i所需要的最小次数， 
方程是： 在跳到i前的j点， j满足（只需一次就能调到i），f[j]也存在，表示能从0通过最小次数跳到j点。

```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/paint-fence
@Language: Markdown
@Datetime: 16-12-22 18:34
```

设S(n)表示当前杆和前一个杆颜色相同的个数，D(n)表示当前杆和前一个颜色不相同的个数。

则递推关系式为：

S(n) = D(n - 1)， 即若当前杆和前一个杆颜色相同的个数等于前一个杆和再前一个杆颜色不相同的个数。

D(n) = (k - 1) * (D(n - 1) + S(n - 1))，即前一个杆和再前一个杆所有可能的颜色组合，乘以当前杆与前一个杆颜色不相同的个数，即（k - 1）。

用两个变量记录D和S，并交替更新即可。
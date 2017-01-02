```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/fast-power
@Language: Markdown
@Datetime: 16-10-26 18:11
```

(a*a*a*a*a*a ) % b = 
					{ [(a*a*a) % b] * [(a*a*a) % b] } % b;
					
					简而言之，一个数n求余数，等于n分为两半以后， 对n/2求余数之后 相乘起来，  再求一遍余数
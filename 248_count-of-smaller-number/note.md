```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/count-of-smaller-number
@Language: Markdown
@Datetime: 16-11-16 15:40
```

Arrays.sort(A);
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		for(int i = 0; i < queries.length;i++){
			int count =0;
			for(int j =0; j < A.length; j++){
				
				if(A[j] == queries[i]){
					break;
				}else if(A[j] < queries[i]){
					count++;
				}	
			}
			res.add(count);
			
			
		}
		return res;
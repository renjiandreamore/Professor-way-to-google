```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/sort-colors-ii
@Language: Markdown
@Datetime: 16-12-06 05:57
```

用 count<k 记录还剩几个数没count

本质上和排列0，1，2方法一致
只是排列k个连续的：
先找到最小和最大，分别把最小最大放在最左最右
然后移动指针，找除了此二者（eg 1-4 中的1 和4）之外最小和最大的数（2，3）
循环往复。
（把 min<数<max 的这段数当成一个。)


class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        //Arrays.sort(colors);
        if(colors.length == 0 || colors == null){
            return;
        }
        int start = 0;
        int end = colors.length - 1;
        int count = 0; // count 表示 还剩k-count个没找到
		
		while(count < k){
		    int max = Integer.MIN_VALUE;
		    int min = Integer.MAX_VALUE;
		    for(int i = start; i <= end; i++){
		        max = Math.max(max, colors[i]);
		        min = Math.min(min, colors[i]);
		    }
		    
		    int left = start;
		    int right = end;
		    int cursor = left;
		    
		    while(cursor <= right){
		        if(colors[cursor] < max && colors[cursor] > min){
		            cursor++;
		        }else if(colors[cursor] == min){
		            swap(colors, left, cursor);
		            left++;
		            cursor++;
		        }else{
		            swap(colors, right, cursor);
		            right--;
		        }
		    }
		    count += 2;
		    start = left;
		    end = right;
		}
	}
	
	public void swap(int[] colors, int i, int j){
		int temp = colors[i];
		colors[i] = colors[j];
		colors[j] = temp;
	
    }
}
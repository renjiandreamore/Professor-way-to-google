/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/longest-consecutive-sequence
@Language: Java
@Datetime: 16-12-01 03:47
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < num.length; i++){
            set.add(num[i]);
        }
        
        int longest = 0;
        
        for(int i = 0; i < num.length; i++){
            int less = num[i] - 1;
            while(set.contains(less)){
                //set.remove(less);       //此题关键在于remove, 否则时间复杂度高
                                        // remove 表示已有一个数到达过这个数，
                                        // 就不用再计算一遍
                less--;
            }
            
            int more = num[i] + 1;
            while(set.contains(more)){
                set.remove(more);
                more++;
            }
            
            longest = Math.max(more - less - 1, longest);
        }
        
        return longest;
    }
}
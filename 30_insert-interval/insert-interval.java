/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/insert-interval
@Language: Java
@Datetime: 16-10-22 22:55
*/

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * Insert newInterval into intervals.
     * @param intervals: Sorted interval list.
     * @param newInterval: A new interval.
     * @return: A new sorted interval list.
     */
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if(intervals == null || newInterval == null){
            return intervals;
        }
        ArrayList<Interval> result = new ArrayList<Interval>();
        int pos = 0;
        // write your code here
        for(Interval interval : intervals){
            if(interval.end < newInterval.start){
                result.add(interval);
                pos ++;
            }else if(newInterval.end < interval.start){
                result.add(interval);
            }else{
                newInterval.start = Math.min(interval.start, newInterval.start);
                newInterval.end = Math.max(interval.end, newInterval.end);
            }
        }
        result.add(pos, newInterval);
        
        return result;
    }
}
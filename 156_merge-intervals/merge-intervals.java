/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/merge-intervals
@Language: Java
@Datetime: 16-10-26 17:34
*/

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals, a collection of intervals
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        if(intervals == null || intervals.size()==0){
            return intervals;
        }
        Collections.sort(intervals, new listSortComparator());
        
        List<Interval> res = new ArrayList<>();
        Interval last = intervals.get(0);
        
        for(int i = 1; i < intervals.size(); i++) {
            Interval crt = intervals.get(i);
            if(crt.start <= last.end){
                last.end = Math.max(last.end, crt.end);
            }else{
                res.add(last);
                last = crt;
            }
        }
        res.add(last);
        return res;
    }
    
    public class listSortComparator implements Comparator<Interval>{
        public int compare(Interval a, Interval b){
            return a.start - b.start;
        }
    }

}
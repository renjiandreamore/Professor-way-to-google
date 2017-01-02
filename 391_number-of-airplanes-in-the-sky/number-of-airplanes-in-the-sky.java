/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/number-of-airplanes-in-the-sky
@Language: Java
@Datetime: 16-11-13 04:18
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
 
class TimePoint{
    public int time;
    public int inSky;
    
    public TimePoint(int time, int inSky){
        this.time = time;
        this.inSky = inSky;
    }
}


class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
     
    public Comparator<TimePoint> timeComparator = new Comparator<TimePoint>(){
        public int compare(TimePoint a, TimePoint b){
            if(a.time == b.time){
                return a.inSky - b.inSky;
            }else{
                return a.time - b.time;
            }
        }
    };
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        if(airplanes == null || airplanes.size() == 0){
            return 0;
        }
        ArrayList<TimePoint> list = new ArrayList<>();
        for(Interval i : airplanes){
            list.add(new TimePoint(i.start, 1));
            list.add(new TimePoint(i.end, 0));
        }
        
        Collections.sort(list, timeComparator);
        int count = 0, sum = 0;
        for(TimePoint p : list){
            if(p.inSky == 1){
                count ++;
            }else{
                count--;
            }
            sum = Math.max(sum, count);
        }
        
        return sum;
    }
}
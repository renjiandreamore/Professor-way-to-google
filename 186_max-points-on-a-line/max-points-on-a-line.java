/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/max-points-on-a-line
@Language: Java
@Datetime: 16-11-06 02:34
*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param points an array of point
     * @return an integer
     */
    public int maxPoints(Point[] points) {
        // Write your code here
        if(points==null || points.length == 0){
            return 0;
        }
        if(points.length == 2){
            return 2;
        }
        
        HashMap<Double, Integer> map = new HashMap<>();
        int len = points.length;
        int count = 1;
        
        for(int i = 0; i < len; i++){
            map.clear();
            map.put((double)Integer.MIN_VALUE, 1); //several same points. 
            
            int dup = 0;
            for(int j = i + 1; j < len; j++){
                if(points[i].x == points[j].x && points[i].y == points[j].y){
                    dup++;
                    continue;
                }
                
                double slope = getSlope(points[i], points[j]);
                if(!map.containsKey(slope)){
                    map.put(slope, 2);
                }else{
                    map.put(slope, map.get(slope)+1);
                }
            }
            for(int k : map.values()){
                count = Math.max(count, k + dup);
            }
        }
        
        return count;
        
    }
    
    public double getSlope(Point a, Point b){
        if(a.x == b.x && b.y == a.y){
            return Integer.MIN_VALUE;
        }
        if(a.x == b.x){
            return Integer.MAX_VALUE;
        }
        return (double)(b.y - a.y) / (double)(b.x - a.x);
    }
}
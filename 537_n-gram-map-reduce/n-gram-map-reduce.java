/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/n-gram-map-reduce
@Language: Java
@Datetime: 16-12-22 15:15
*/

/**
 * Definition of OutputCollector:
 * class OutputCollector<K, V> {
 *     public void collect(K key, V value);
 *         // Adds a key/value pair to the output buffer
 * }
 */
public class NGram {

    public static class Map {
        public void map(String _, int n, String str,
                        OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, Integer value);
            for(int i = 0; i+n <= str.length(); i++){
                String s = str.substring(i, i+n);
                output.collect(s, 1);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            int count = 0;
            while(values.hasNext()){
                count += values.next();
            }
            output.collect(key, count);
        }
    }
}
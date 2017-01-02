/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/word-count-map-reduce
@Language: Java
@Datetime: 16-10-17 00:48
*/

/**
 * Definition of OutputCollector:
 * class OutputCollector<K, V> {
 *     public void collect(K key, V value);
 *         // Adds a key/value pair to the output buffer
 * }
 */
public class WordCount {

    public static class Map {
        public void map(String key, String value, OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            
            String[] words = value.split(" ");
            //key = word
            // value = 1
            for(String word : words){
                String outKey = word;
                int outValue = 1; 
                output.collect(outKey, outValue);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            //key = word
            // value <1,1,1,1>
            int sum = 0;
            while(values.hasNext()){
                sum += values.next();
            }
            
            output.collect(key, sum);
        }
    }
}

/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/super-ugly-number
@Language: Java
@Datetime: 16-11-25 00:00
*/

public class Solution {
    /**
     * @param n a positive integer
     * @param primes the given prime list
     * @return the nth super ugly number
     */
    public int nthSuperUglyNumber(int n, int[] primes) {
        // Write your code here
        if(primes == null || primes.length == 0 || n <=0){
            return 0;
        }
        
        Queue<Long> q = new PriorityQueue<>();
        HashSet<Long> inqueue = new HashSet<>();
        
        for(int i = 0; i < primes.length; i++){
            q.offer((long)primes[i]);
            inqueue.add((long)primes[i]);
        }
        
        Long res = (long) 1;
        for(int i = 1; i < n; i++){
            res = q.poll();  //2
            for(int j = 0; j < primes.length; j++){
                if(!inqueue.contains((long)primes[j] * res)){
                    q.offer((long)primes[j] * res);
                    inqueue.add((long)primes[j] * res);
                }
            }
        }
        
        return (int) (long)res; 
    }
}
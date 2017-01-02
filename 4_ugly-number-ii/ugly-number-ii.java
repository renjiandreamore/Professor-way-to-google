/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/ugly-number-ii
@Language: Java
@Datetime: 16-09-20 17:14
*/

class Solution {
    /**
     * @param n an integer
     * @return the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        // Write your code here
        Queue<Long> q = new PriorityQueue<Long>();
    	HashSet<Long> inQ = new HashSet<Long>();
    	Long[] threeBasic = new Long[3];
    	threeBasic[0] = (long) 2;
    	threeBasic[1] = (long) 3;
    	threeBasic[2] = (long) 5;
    	
    	for(int i = 0; i < 3; i++){
    		q.add(threeBasic[i]);
    		inQ.add(threeBasic[i]);

    	}
    	Long res = (long) 1;
    	for(int i = 1; i < n; i++){
    		res = q.poll();
    		for(int j = 0; j < 3; j++){
    			if(!inQ.contains(threeBasic[j] * res)){
    				q.add(threeBasic[j] * res);
    				inQ.add(threeBasic[j] * res);
    			}
    		}
    	}
    	return res.intValue();
    }
    //     int res = 0;
    //     int number = 1;
    //     int i = 0;
    //     while( i < n){
    //         if(isUglyNumber(number)){
    //             i++;
    //             res = number;
    //         }
    //         number++;
    //     }
    //     return res;
    // }
    
    // public boolean isUglyNumber(int x){
        
    //     while(x % 2 == 0){
    //         x = x / 2;
    //     }
        
    //     while(x % 3 == 0){
    //         x = x / 3;
    //     }
        
    //     while( x % 5 == 0){
    //         x = x / 5;
    //     }  
       
        
        
    //     if(x == 1) return true;
    //     else return false; 
    // }
}

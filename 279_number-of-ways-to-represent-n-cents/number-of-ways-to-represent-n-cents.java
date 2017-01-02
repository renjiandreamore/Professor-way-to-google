/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/number-of-ways-to-represent-n-cents
@Language: Java
@Datetime: 16-10-05 15:25
*/

public class Solution {
    /**
     * @param n an integer
     * @return an integer
     */
    public int waysNCents(int n) {
        // Write your code here
        int[] f = new int[n+1];
        f[0] = 1;
        int[] cents = new int[]{1,5,10,25};
        for(int i = 0; i < 4; i++){
            for(int j = 1; j <= n; j++){
                if(j>=cents[i]){
                    f[j] = f[j] + f[j-cents[i]];
                }
            }
        }
        
        return f[n];
        
        // int[] f = new int[n+1];
        // f[0] = 1;
        // int[] cents = new int[]{1, 5, 10, 25};
        // for (int i = 0; i < 4; i++) 
        //     for (int j = 1; j <= n; j++) {
        //         if (j >= cents[i]) {
        //             f[j] += f[j-cents[i]];
        //         }
        //     }
        // return f[n];
        
    }
}
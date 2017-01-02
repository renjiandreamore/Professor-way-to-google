/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/powx-n
@Language: Java
@Datetime: 16-10-26 18:22
*/

public class Solution {
    /**
     * @param x the base number
     * @param n the power number
     * @return the result
     */
    public double myPow(double x, int n) {
        // Write your code here
        // if(x == 0) return 0;
        // if(n == 0) return 1;
        // if(n == 1) return x;
        
        // boolean isNegative = false;
        // if (n < 0) {
        //     isNegative = true;
        //     n *= -1;
        // }
        
        // double half = myPow(x, n/2);
        // double rst = half * half;
        // if(n % 2 == 1){
        //     rst = rst * x;
        // }
        // if(isNegative){
        //     return 1/rst;
        // }
        // return rst;
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n *= -1;
        }

        int k = n / 2;
        int l = n - k * 2;
        double t1 = myPow(x, k);
        double t2 = myPow(x, l);
        if (isNegative) {
            return 1/(t1*t1*t2);
        } else {
            return t1*t1*t2;
        }
    }
}
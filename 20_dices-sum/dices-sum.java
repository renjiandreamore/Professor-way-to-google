/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/dices-sum
@Language: Java
@Datetime: 16-10-24 22:37
*/

public class Solution {
    /**
     * @param n an integer
     * @return a list of Map.Entry<sum, probability>
     */
    public List<Map.Entry<Integer, Double>> dicesSum(int n) {
        // Write your code here
        // Ps. new AbstractMap.SimpleEntry<Integer, Double>(sum, pro)
        // to create the pair
        
        List<Map.Entry<Integer, Double>> res = new ArrayList<>();
        
        double[][] matrix = new double[n+1][6*n + 1];
        //the probability that n dices gives to the each sum from n - 6n
        
        for(int i = 1; i <= 6; i++){
            matrix[1][i] = 1/6.0; // 1/6 ?
        }
        
        for(int i = 1; i <= n ; i++){
            for(int j = i; j <= 6*i; j ++){  //6*n?
                for(int k = 1; k<= 6; k++){ // k means the last one dice from 1 - 6
                    if(j > k){
                        matrix[i][j] += matrix[i-1][j-k]/6.0;
                    }
                }
                
            }
        }
        
        for(int i = n; i <= 6 * n; i++){
            Map.Entry<Integer, Double> map = new AbstractMap.SimpleEntry<Integer, Double>(i, matrix[n][i]);
            res.add(map);
        }
        
        return res;
    }
}
/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/3sum-closest
@Language: Java
@Datetime: 16-11-02 14:52
*/

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        // write your code here
        if(numbers == null || numbers.length < 3){
            return -1;  //means not found
        }
        
        Arrays.sort(numbers);
        int best =Integer.MAX_VALUE; //numbers[0] + numbers[1] + numbers[2];
        for(int i = 0; i < numbers.length; i++){
            int left = i + 1;
            int end = numbers.length - 1;
            while(left < end){
                int sum = numbers[i] + numbers[left] + numbers[end];
                if(Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if(sum < target){
                    left++;
                }
                else{
                    end--;
                }
            }
        }
        
        return best;
    }
}

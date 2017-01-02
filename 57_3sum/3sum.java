/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/3sum
@Language: Java
@Datetime: 16-03-30 19:48
*/

public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        int len = numbers.length;
        
        if(numbers == null || numbers.length < 3){
            return res;
        }
        Arrays.sort(numbers);
        for(int i = 0; i < len-2; i++){
            
            if(i != 0 && numbers[i] == numbers[i-1]){
                continue;
            }
            int left = i + 1, right = len - 1;
            while(left < right){
                
                int sum = numbers[i] + numbers[left] + numbers[right];
                if(sum == 0){
                    ArrayList<Integer> oneOfres = new ArrayList<Integer>();
                    oneOfres.add(numbers[i]);
                    oneOfres.add(numbers[left]);
                    oneOfres.add(numbers[right]);
                    res.add(oneOfres);
                    left++;
                    right--;
                    while(left < right && numbers[left] == numbers[left - 1]){
                        left++;
                    }
                    while(left < right && numbers[right] == numbers[right + 1]){
                        right--;
                    }
                }
                else if(sum < 0){
                    left ++;
                }else{
                    right --;
                }
            }
            
        }
        return res;
     
     
        
    }
}
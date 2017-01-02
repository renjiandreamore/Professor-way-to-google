/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/4sum
@Language: Java
@Datetime: 16-04-02 18:56
*/

public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        /* your code */
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(numbers);
        int len = numbers.length;
        
        if(numbers == null || len < 4){
            return res;
        }
        
        for(int i = 0; i < len-3; i++){
            if(i != 0 && numbers[i] == numbers[i-1]){
                continue;
            }
            for(int j = i + 1; j < len-2; j++){
                if(j != i + 1 && numbers[j] == numbers[j-1]){
                    continue;
                }
                int left = j + 1;
                int right = len - 1;
                
                while(left < right){
                    
                    int sum = numbers[i] + numbers[j] + numbers[left] + numbers[right];
                    if(sum == target){
                        ArrayList<Integer> temp = new ArrayList<Integer>();
                        temp.add(numbers[i]);
                        temp.add(numbers[j]);
                        temp.add(numbers[left]);
                        temp.add(numbers[right]);
                        res.add(temp);
                        left ++;
                        right --;
                        while(numbers[left] == numbers[left - 1]){
                            left++;
                        }
                        while(numbers[right] == numbers[right + 1]){
                            right--;
                        }
                    }
                    else if( sum < target){
                        left ++;
                    }else {
                        right --;
                    }
                }
            } 
        }
        return res;
    }
}
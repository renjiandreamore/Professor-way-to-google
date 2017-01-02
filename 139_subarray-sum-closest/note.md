```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/subarray-sum-closest
@Language: Markdown
@Datetime: 16-04-02 18:55
```

写成下面这样时间超时


 public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
     public int[] subarraySumClosest(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return null;
         }
        
        int[] rest = new int[2];
        //int[] temp = new int[nums.length];
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i<nums.length; i++){
            int sum = nums[i];
            for(int j = i +1; j<nums.length; j++){
                sum += nums[j];
                if(Math.abs(sum) < min){
                    //sum = nums[i] + nums[j];
                    min = Math.abs(sum);
                }
            }
        }
        for(int i =0; i<nums.length; i++){
            if(min > Math.abs(nums[i])){
                min = Math.abs(nums[i]);
                rest[0] = i;
                rest[1] = i;
                //return rest;
            }
        }
        
        for(int i = 0; i< nums.length; i++){
            int sum1 = nums[i];
            for(int j = i + 1; j < nums.length; j++){
                 sum1 += nums[j];
                 if(Math.abs(sum1) == min){
                     rest[0] = i;
                     rest[1] = j;
                     return rest;
                 }
            }
        }
        return rest;
        
    }
}



对pair进行排序，就是按照前缀值从小到大排序，这样使得越接近的两个数刚刚互相挨着。那么最近接0的子段一定产生于排在相邻位置上的两个前缀。
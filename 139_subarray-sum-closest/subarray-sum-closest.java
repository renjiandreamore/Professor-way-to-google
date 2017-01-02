/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/subarray-sum-closest
@Language: Java
@Datetime: 16-04-02 18:55
*/

class pair{
    int sum;
    int index;
    public pair(int sum, int index){
        this.sum = sum;
        this.index = index;
    }
}


public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] res = new int[2];
        int len = nums.length;
        
        if(nums.length == 0 || nums == null){
            return res;
        }
        if(nums.length == 1){
          res[0] = res[1] = 0;   
        }
        
        pair[] presum = new pair[len + 1];
        presum[0] = new pair(0,0);
        int prev = 0;
        
        for(int i = 1; i <= len; i++){
            presum[i] = new pair(prev + nums[i-1], i);
            prev = presum[i].sum;
        }
        
       
        Arrays.sort(presum, new Comparator<pair>(){
            public int compare(pair a, pair b){
                return a.sum - b.sum;
            }
        });
        
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= len; i++){
            if(min > presum[i].sum - presum[i-1].sum){
                min = presum[i].sum - presum[i-1].sum;
                int[] temp = new int[]{presum[i].index - 1, presum[i - 1].index - 1}; //加一temp 意思是：只有小的index不变，大的-1，但是不知道哪个在前哪个在后，所以先存在temp里，再sort，再存进res；
                Arrays.sort(temp);
                res[0] = temp[0] + 1;
                res[1] = temp[1];
            }
        }
        
        
        
        return res;
        
    }
}

/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/sliding-window-maximum
@Language: Java
@Datetime: 16-11-03 05:28
*/

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> res = new ArrayList<>();
        
        if(nums == null || nums.length == 0 ){
            return res;
        }
        
        int n = nums.length;
    //     for(int i = 0; i <= n - k; i++){
    //         int x = getMax(nums, i, i + k - 1);
    //         res.add(x);
    //     }
    //     return res;
    // }
    
    // public int getMax(int[] nums, int i, int j){
    //     int res = Integer.MIN_VALUE;
    //     for(int k = i; k <= j; k++ ){
    //         res = Math.max(res, nums[k]);
    //     }
    //     return res;
    // }
    
    /*
    version 2: Priority Queue 超时 
    */
    
        // PriorityQueue<Integer> pq = new PriorityQueue<>(100, new Comparator<Integer>(){
        //     public int compare(Integer a, Integer b){
        //         return b - a;
        //     }
        // });
        
        // for(int i = 0; i < n; i++){
        //     if(i >= k){
        //         pq.remove(nums[i-k]);
        //     }
        //     pq.offer(nums[i]);
        //     if(i + 1 >= k){
        //         res.add(pq.peek());
        //     }
        // }
    
        // return res;
        
    /*
    version 3: dequeue
    */
    
    
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < k - 1; i++){
            inque(dq, nums[i]); 
            //**关键：！！！保证从最高的那个，到最后新加入进来的那个，中间全是降序
        }
        
        for(int i = k - 1; i < n; i++){
            inque(dq, nums[i]);
            res.add(dq.peekFirst());
            outque(dq, nums[i-k + 1]);
        }
        return res;
        
    
    }
    
    void inque(Deque<Integer> dq, int num){
        while(!dq.isEmpty() && dq.peekLast()<num ){
            dq.pollLast();
        }
        dq.offer(num);
        //保证dq是降序    // 4,3, 1, -2  offer(2) --->  4,3,2    
        //后面的都扔了 
    }
    
    void outque(Deque<Integer> dq, int num){
        if(dq.peekFirst()==num){
            dq.pollFirst();
        }
    }
    
    
}

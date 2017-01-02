/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/top-k-largest-numbers-ii
@Language: Java
@Datetime: 16-09-14 20:04
*/

public class Solution {
    int maxSize;
    Queue<Integer> minHeap;

    public Solution(int k) {
        maxSize = k;
        minHeap = new PriorityQueue<>();
        // initialize your data structure here.
    }

    public void add(int num) {
        // Write your code here
        if(minHeap.size()<maxSize){
            minHeap.offer(num);
        
        }else if(num > minHeap.peek()){
            minHeap.poll();
            minHeap.offer(num);
        }
    }

    public List<Integer> topk() {
        // Write your code here
        Iterator it = minHeap.iterator();
        ArrayList<Integer> res = new ArrayList<>();
        while(it.hasNext()){
            res.add((Integer)it.next());
        }
        
        Collections.sort(res, Collections.reverseOrder());
        return res;
    }
};
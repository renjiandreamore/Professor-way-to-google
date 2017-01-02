/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/merge-k-sorted-arrays
@Language: Java
@Datetime: 16-09-21 01:13
*/

class E{
    int row;
    int col;
    int value;
    
    public E(int row, int col, int value){
        this.row = row;
        this.col = col;
        this.value = value;
    }
}

public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     * 
     * 按照comparator定义的E的value大小从小到大排列
     * 打入PQ，pq长度为k，必定是从小到大排
     * 然后poll（）出最小的
     * 加入res，{
         如果poll出的element，不是那一行的最后一个：ele.col + 1 < arrays[ele.row].length
         继续把col++， value变成之后的那个value，row不变，加入pq，让他自己找到属于自己的位置
         再poll
            再重复
     }
     */
    private Comparator<E> elementComparator = new Comparator<E>(){
        public int compare(E e1, E e2){
            return e1.value - e2.value;
        }
    };
    
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        List<Integer> res = new ArrayList<Integer>();
        
        if(arrays == null || arrays.length == 0){
            return null;
        }
        
        int total_size = 0;
        Queue<E> queue = new PriorityQueue<E>(arrays.length, elementComparator);
        for(int i = 0; i < arrays.length; i++){
            if(arrays[i].length > 0){
                E element = new E(i, 0, arrays[i][0]);
                queue.add(element);
                //total_size += arrays[i].length;
            }
        }
        
        //int index = 0;
        while(!queue.isEmpty()){
            E ele = queue.poll();
            res.add(ele.value);
            if(ele.col + 1 < arrays[ele.row].length){
                ele.col ++;
                ele.value = arrays[ele.row][ele.col];
                queue.add(ele);
            }
        }
        return res;
    }
}
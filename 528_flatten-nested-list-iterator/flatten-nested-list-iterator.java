/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/flatten-nested-list-iterator
@Language: Java
@Datetime: 16-11-24 23:05
*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
import java.util.Iterator;

public class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> nestedList;
    Stack<NestedInteger> st = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        // Initialize your data structure here.
        this.nestedList = nestedList;
        for(int i = nestedList.size()-1; i>=0; i-- ){
            st.push(nestedList.get(i));
        }
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
        // Write your code here
        nestedList.get(0);
        return st.pop().getInteger();
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
        while(!st.isEmpty()){
            if(st.peek().isInteger()){
                return true;
            }
            List<NestedInteger> level = st.pop().getList();
            for(int i = level.size()-1; i>= 0; i--) {
                st.push(level.get(i));
            }
        }
        return false;
    }

    @Override
    public void remove() {}
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v.add(i.next());
 */
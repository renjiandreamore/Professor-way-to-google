```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/implement-three-stacks-by-single-array
@Language: Markdown
@Datetime: 16-12-04 17:30
```

public class ThreeStacks {
    public int stackSize;
    public int indexReached;
    public int[] pointer;
    public Node[] nodesArray;

    public ThreeStacks(int size) {
        // do intialization if necessary
        stackSize = size;
        pointer = new int[3];
        for(int i = 0; i < 3; i++){
            pointer[i] = -1;
        }
        indexReached = 0;
        nodesArray = new Node[stackSize * 3];
    }

    public void push(int stackNum, int value) {
        // Write your code here
        // Push value into stackNum stack
        int lastIndex = pointer[stackNum];
        pointer[stackNum] = indexReached;
        nodesArray[indexReached] = new Node(lastIndex, value);
        indexReached++;
    }
    
    public int pop(int stackNum) {
        // Write your code here
        // Pop and return the top element from stackNum stack
        int arrayIndex = pointer[stackNum];
        if(arrayIndex == -1) return 0;
        int val = nodesArray[arrayIndex].value;
        
        pointer[stackNum] = nodesArray[arrayIndex].prev;
        nodesArray[arrayIndex] = null;
        //indexReached--;
        return val;
    }

    public int peek(int stackNum) {
        // Write your code here
        // Return the top element
        if(pointer[stackNum] == -1) return 0;
        return nodesArray[pointer[stackNum]].value;
    }

    public boolean isEmpty(int stackNum) {
        // Write your code here
        return pointer[stackNum] == -1;
    }
}

class Node{
    int prev;
    int value;
    public Node(int prev, int value){
        this.prev = prev;
        this.value = value;
    }
}
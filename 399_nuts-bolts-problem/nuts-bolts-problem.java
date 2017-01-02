/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/nuts-bolts-problem
@Language: Java
@Datetime: 16-11-22 21:30
*/

/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
public class Solution {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
        if(nuts == null || nuts.length == 0 || bolts == null || bolts.length == 0) return;
        
        int m = nuts.length;
        int n = bolts.length;
        
        for(int i = 0; i < m; i++){
            for(int j = i; j < n; j++){
                if(compare.cmp(nuts[i], bolts[j]) == 0){
                    String tmp = bolts[i];
                    bolts[i] = bolts[j];
                    bolts[j] = tmp;
                    break;
                }
            }
        }
        
        
    }
};
/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/interleaving-positive-and-negative-numbers
@Language: Java
@Datetime: 16-04-04 21:29
*/

class Solution {
    /**
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] A) {
        // write your code here
        int len = A.length;
        int[] ap = new int[len];
        int[] an = new int[len];
        int pnum = 0, nnum = 0;
        int[] temp = new int[len];
        
        for(int i = 0; i<len; i++){
            if(A[i] >= 0){
                ap[pnum] = A[i];
                pnum++;
            }else {
                an[nnum] = A[i];
                nnum++;
            }
        }
        
        if(pnum >= nnum){
            temp = pasteTwo(ap, an, len);
        }else {
            temp = pasteTwo(an, ap, len);
        }
        for(int i = 0; i< len; i++){
            A[i] = temp[i];
        }
        
   }
   int[] pasteTwo(int[] a, int[] b, int len){
       int res[] = new int[len];
       
       for(int i =0; 2*i + 1 < len; i++){
           res[i*2] = a[i];
           res[i*2 + 1] = b[i];
       }
       if(len%2 == 1){
           res[len - 1] = a[len / 2];
       }
       return res;
   }
}
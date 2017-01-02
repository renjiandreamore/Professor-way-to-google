/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/permutation-index-ii
@Language: Java
@Datetime: 16-11-10 16:03
*/

public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndexII(int[] A) {
        //Write your code here
        if(A == null || A.length == 1){
            return (long) 0;
        }
        
        int len = A.length;
        
        long res = 0;
        
        long fact = 1;
        long mulFact = 1;
        
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = len-1; i >= 0; i--){
            if (!map.containsKey(A[i])) {
                 map.put(A[i], 1);
             }
             else {
                 map.put(A[i], map.get(A[i])+1);
                 mulFact *= map.get(A[i]);
             }
             
             int count = 0;
             
             for(int j = i +1; j < len; j++){
                 if(A[i] > A[j]) count ++;
             }
             
             res += count * fact / mulFact;
             fact *= (len - i);
        }
        
        
        
        res = res + 1;
        
        return res;
        
        // if (A==null || A.length==0) return new Long(0);
        //  int len = A.length;
        //  HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        //  long index = 0, fact = 1, mulFact = 1;
        //  for (int i=len-1; i>=0; i--) {
        //      if (!map.containsKey(A[i])) {
        //          map.put(A[i], 1);
        //      }
        //      else {
        //          map.put(A[i], map.get(A[i])+1);
        //          mulFact *= map.get(A[i]);
        //      }
        //      int count = 0;
        //      for (int j=i+1; j<len; j++) {
        //          if (A[i] > A[j]) count++;
        //      }
        //      index += count*fact/mulFact;
        //      fact *= (len-i);
        //  }
        //  index = index + 1;
        //  return index;
    }
    
    
}
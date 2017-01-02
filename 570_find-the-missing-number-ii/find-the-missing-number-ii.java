/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/find-the-missing-number-ii
@Language: Java
@Datetime: 16-10-11 19:59
*/

public class Solution {
    /**
     * @param n an integer
     * @param str a string with number from 1-n
     *            in random order and miss one number
     * @return an integer
     */
     
    public int res = 0;
    public boolean flag = false;
    public int findMissing2(int n, String str) {
        // Write your code here
        boolean[] found = new boolean[n+1];
        //boolean flag = false;
        
        dfs(0, n, str, found);
        return res;
    }
    
    void dfs(int i, int n, String str, boolean[] found){
        if(i >= str.length() || flag){
            if(!flag){
                for(int k = 1; k <= n; k++){
                    if(!found[k]){
                        res = k;
                    }
                }
                flag = true;
            }
            return;
        }
        
        int num = str.charAt(i) - '0';
        int j = i;
        if(num == 0) return;
        
        
        while(num <= n){
            if(!found[num]){
                found[num] = true;
                dfs(j + 1, n, str, found);
                found[num] = false;
            }
            j++;
            if(j>=str.length()) break;
            
            num = num * 10 + (str.charAt(j) - '0');
        }
    }
}
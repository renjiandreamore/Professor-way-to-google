/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/n-queens
@Language: Java
@Datetime: 16-09-27 20:41
*/

class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        if(n <= 0){
            return res;
        }
        
        int[] map = new int[n];
        solveNQueensKernel(res, map, n, 0);
        return res;
    }
    
    void solveNQueensKernel(ArrayList<ArrayList<String>> res, int[] map, int n, int hang){
        if(hang == n){
            ArrayList<String> singleResult = translateString(map);
            res.add(singleResult);
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(isValidPosition(map, hang, i)){ //在已有map(row)的基础上，行hang，列i，是否满足条件
                map[hang] = i;
                    solveNQueensKernel(res, map, n, hang+1);
                //map[hang] = 0;
            }
        }
    }
    
    public ArrayList<String> translateString(int[] row){
        ArrayList<String> res = new ArrayList<>();
        for(int i = 0; i < row.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j =0; j < row.length; j++){
                if(j == row[i]){
                    sb.append("Q");
                }else{
                    sb.append(".");
                }
            }
            res.add(sb.toString());
        }
        return res;
    }
    
    public boolean isValidPosition(int[] map, int rowNum, int colNum){ 
        /*
        表示在当前map的排列基础上，rowNum 和 colNum是否符合摆放规则
        
        map,的基础上，下一行rowNum要怎么放？从0行循环到rowNum之前一行，分别看rowNum这一行要放的位置是否全部满足从0行到rowNum-1行的摆放需求
        */
        //每一行每一列必须有且只有一个
        //不在同一斜线上
        for(int i = 0; i < rowNum; i++){
            if(map[i] == colNum){
                return false;
            }
            if(Math.abs(map[i] - colNum) == Math.abs(i- rowNum)){
                return false;
            }
        }
        return true;
    }
    
    
};
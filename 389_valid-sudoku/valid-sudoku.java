/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/valid-sudoku
@Language: Java
@Datetime: 16-12-24 21:01
*/

class Solution {
    /**
      * @param board: the board
        @return: wether the Sudoku is valid
      */
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length == 0) return false;
        boolean[] checked = new boolean[board.length];
        
        //row
        for(int i = 0; i < board.length; i++){
            Arrays.fill(checked, false);
            for(int j = 0; j < board[0].length; j++){
                if(!OK(checked, board[i][j])){
                    return false;
                }
            }
        }
        
        //col
        for(int i = 0; i < board[0].length; i++){
            Arrays.fill(checked, false);
            for(int j = 0; j < board.length; j++){
                if(!OK(checked, board[j][i])){
                    return false;
                }
            }
        }
        
        //3X3 square
        for(int i = 0; i < board.length; i+= 3){
            for(int j = 0; j < board[0].length; j+= 3) {
                Arrays.fill(checked, false);
                for(int k = 0; k < 9; k++){
                    if(!OK(checked, board[i + k/3][j + k%3])){
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    public boolean OK(boolean[] checked, char ch){
        if(ch == '.'){
            return true;
        }
        
        int num = ch - '0';
        
        if(num < 1 || num > 9 || checked[num-1] == true){
            return false;
        }
        
        checked[num-1] = true;
        return true;
    }
};
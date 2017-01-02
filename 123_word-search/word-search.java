/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/word-search
@Language: Java
@Datetime: 16-12-30 07:03
*/

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        if(board == null || board.length == 0 ) return false;
        if(word == null) return true;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == word.charAt(0)){
                    boolean rst = helper(board, i, j, word, 0);
                    if(rst) return true;
                    //recap 12/30/2016
                    //不能直接return rst
                    //abce
                    //sfcs
                    //adee    word ="see"
                    //会先到第二行一个s，得到fasle，会return false
                }
            }
        }
        
        return false;
    }
    
    public boolean helper(char[][] board, int i, int j, String word, int wordIndex){
        if(wordIndex == word.length() ) return true;
        
        if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length -1 || board[i][j] != word.charAt(wordIndex) ) return false;
        
        board[i][j] = '*';
        boolean rst = helper(board, i - 1, j, word, wordIndex + 1) 
                      || helper(board, i + 1, j, word, wordIndex + 1)
                      || helper(board, i, j - 1, word, wordIndex + 1)
                      || helper(board, i, j + 1, word, wordIndex + 1); 
        board[i][j] = word.charAt(wordIndex);       
        //if not back '*' to its original, ["ABCE","SFES","ADEE"], "ABCESEEEFS" 
        //will fail 
        /*
        
                                 E —— x 
							          |
									  E
					如图，x 有两个方向都可以走E 的时候，万一先走到了错的路上，然而对的那个E  又被  错误的E方向上的接下来的路 走过了， 此时如果不释放'*' ， 那么正确的E 的方向会被标注为'*', 于是就走不到正确的路 了.
        */
        return rst;
    }
    
    
}
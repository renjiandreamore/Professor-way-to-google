```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/word-search-ii
@Language: Markdown
@Datetime: 17-01-02 01:41
```

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        ArrayList<String> rst = new ArrayList<String>();
        if(board == null || board.length == 0) return rst;
        if(words.size() == 0) return rst;
        
        for(String word : words){
            if(existed(board, word) && !rst.contains(word)){
                rst.add(word);
            }
        }
        
        return rst;
    }
    
    public boolean existed(char[][] board, String word){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean rst = helper(board, i, j, word, 0);
                    if(rst) return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean helper(char[][] board, int i, int j, String word, int wordPosition){
        if(wordPosition == word.length()) return true;
        
        if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != word.charAt(wordPosition)) return false;
        
        board[i][j] = '$';
        
        boolean rst = helper(board, i, j + 1, word, wordPosition + 1) || helper(board, i + 1, j, word, wordPosition + 1) || helper(board, i, j - 1, word, wordPosition + 1) || helper(board, i - 1, j, word, wordPosition + 1);
        
        board[i][j] = word.charAt(wordPosition);
        
        return rst;
    }
}
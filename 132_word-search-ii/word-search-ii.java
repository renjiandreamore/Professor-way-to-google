/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/word-search-ii
@Language: Java
@Datetime: 17-01-02 01:41
*/

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     * 先建立trie
     * exisit就不要了
     * 字典里加入trie
     * dfs搜索board
     * 如果当前组成的string在trie里，继续搜，否则停。
     * 搜到后加入list 
     */
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        ArrayList<String> res = new ArrayList<String>();
        if(board == null || board.length == 0 || words == null || words.size() == 0 ){
            return res;
        }
        
        Trie trie = new Trie();
        for(String s : words){
            trie.insert(s);
        }
        
        String word = "";
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, trie, word, i, j, res);
            }
        }
        
        return res;
    }
    
    public void dfs(char[][]board, Trie trie, String word, int i, int j, ArrayList<String> res ){
        if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1){
            return;
        }
        if(board[i][j] == '$') return;
        word += board[i][j];
        
        if(!trie.startsWith(word)) return;
        if(trie.search(word) && !res.contains(word)){
            res.add(word);
        }
        
        char tmp = board[i][j];
        board[i][j] = '$';
        dfs(board, trie, word, i, j+1, res);
        dfs(board, trie, word, i+1, j, res);
        dfs(board, trie, word, i, j-1, res);
        dfs(board, trie, word, i-1, j, res);
        board[i][j] = tmp;
        
    }
}

class Trie{
    TrieNode root;
    public Trie(){
        this.root = new TrieNode();
    }
    
    public void insert(String word){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int num = c - 'a';
            if(node.child[num] == null){
                node.child[num] = new TrieNode();
            }
            node = node.child[num];
        }
        
        node.item = word;
    }
    
    public boolean search(String word){
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int num = c - 'a';
            if(node.child[num] == null) return false;
            node = node.child[num];
        }
        return node.item.equals(word);
    }
    
    public boolean startsWith(String prefix){
        TrieNode node = root;
        for(char c : prefix.toCharArray()){
            int num = c - 'a';
            if(node.child[num] == null) return false;
            node = node.child[num];
        }
        return true;
    }
}

class TrieNode{
    String item = "";
    TrieNode[] child = new TrieNode[26];
}
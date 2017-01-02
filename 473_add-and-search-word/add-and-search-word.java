/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/add-and-search-word
@Language: Java
@Datetime: 17-01-01 20:23
*/

public class WordDictionary {
    TrieNode root;
    public WordDictionary(){
        this.root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
        TrieNode node = root;
        for(char c : word.toCharArray()){
            int num = c - 'a';
            if(node.child[num] == null){
                node.child[num] = new TrieNode();
            }
            node = node.child[num];
        }
        node.hasWord = true;
    }
    public boolean search(String word){
        return find(word, 0, root);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean find(String word, int index, TrieNode node) {
        // Write your code here
        
        if(index == word.length()) return node.hasWord;
        
        char c = word.charAt(index);
        if(c == '.'){
            for(int i = 0; i < 26; i++){
                if(node.child[i] != null){
                    boolean rst = find(word, index+1, node.child[i]);
                    if(rst) return true;
                }
            }
            return false;
        }else{
            int num = c - 'a';
            if(node.child[num] == null) return false;
            return find(word, index + 1, node.child[num]);
        }
        
    }
}

class TrieNode{
    boolean hasWord;
    TrieNode[] child;
    public TrieNode(){
        this.hasWord = false;
        this.child = new TrieNode[26];
    }
}


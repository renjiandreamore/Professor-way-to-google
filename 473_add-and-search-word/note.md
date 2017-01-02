```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/add-and-search-word
@Language: Markdown
@Datetime: 17-01-01 20:23
```

public class WordDictionary {
    
    TrieNode root;
    public WordDictionary(){
        this.root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
        TrieNode now = root;
        for(int i = 0 ; i < word.length();i++){
            int pos = word.charAt(i) - 'a';
            if(now.children[pos] == null){
                now.children[pos] = new TrieNode();
            }
            now = now.children[pos];
        }
        now.hasWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        return find(word, 0, root);
    }
    
    boolean find(String word, int index, TrieNode now){
        if(index == word.length()){
            return now.hasWord;
        }
        
        char c = word.charAt(index);
        if(c == '.'){
            for(int i = 0; i < 26; i++){
                if(now.children[i] != null){
                    if(find(word, index + 1, now.children[i])){
                        return true;
                    }
                }
            }
            return false;
        }else if(now.children[c - 'a'] != null){
            return find(word, index+1, now.children[c-'a']);
        }else{
            return false;
        }
    }
}

class TrieNode{
    public TrieNode[] children;
    public boolean hasWord;
    public TrieNode(){
        this.children = new TrieNode[26];
        this.hasWord = false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/implement-trie
@Language: Markdown
@Datetime: 17-01-01 19:47
```

此题里的trie只是能知道有没有这个word，boolean判断

并不能告诉word是什么

但是如果把hasword 换成 string item,就可以知道word是什么(如图第二次改写)


/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    public boolean hasWord;
    public TrieNode[] children;
    // Initialize your data structure here.
    public TrieNode() {
        this.children = new TrieNode[26];
        this.hasWord = false;
    }
    
    public void insert(String word, int index){
        if(index==word.length()){
            this.hasWord = true;
            return;
        }
        
        int pos = word.charAt(index)-'a';
        if(children[pos] == null){
            children[pos] = new TrieNode();
        }
        children[pos].insert(word, index+1);
    }
    
    public TrieNode find(String word, int index){
        if(index == word.length()){
            return this;
        }
        
        int pos = word.charAt(index) - 'a';
        if(children[pos] == null){
            return null;
        }
        return children[pos].find(word, index+1);
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.insert(word, 0);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root.find(word, 0);
        return (node!= null && node.hasWord == true);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root.find(prefix, 0);
        return node!= null;
    }
}
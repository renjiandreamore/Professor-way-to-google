/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/implement-trie
@Language: Java
@Datetime: 17-01-01 19:47
*/



public class Trie {
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
		//node.hasWord = true;
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
		
		return node != null;
	}
}

class TrieNode{
	//boolean hasWord;
	String item;
	TrieNode[] child;
	public TrieNode(){
		//this.hasWord = false;
		this.item = "";
		this.child = new TrieNode[26];
	}
}

/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/word-ladder
@Language: Java
@Datetime: 16-09-30 22:36
*/

public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if(dict == null){
			return 0;
		}
		if(start.equals(end)){  //比较两个字符串，不能用==， 要用equals
		    return 1;
		}
		
		dict.add(start);
		dict.add(end);
		
		HashSet<String> hash = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		hash.add(start);
		
		int length = 1;
		while(!queue.isEmpty()){
			length ++;
			int size = queue.size();
			for(int i =0; i< size; i++){
				String word = queue.poll();
				for(String nextword: getNextWords(word, dict)){
					if(hash.contains(nextword)){
						continue;
					}
					if(nextword.equals(end)){
						return length;
					}
					
					hash.add(nextword);
					queue.offer(nextword);
				}
			}
		}
		return length;
		
	}
	
	private ArrayList<String> getNextWords(String word, Set<String> dict){
		ArrayList<String> nextwords = new ArrayList<String>();
		
		for(char c = 'a'; c<= 'z'; c++ ){
			for(int i =0; i< word.length(); i++){
				if(word.charAt(i) == c){
					continue;
				}
				String replace2Next = replace(word, i, c);
				if(dict.contains(replace2Next)){
					nextwords.add(replace2Next);
				}
			}
		}
		return nextwords;
	}
	
	private String replace(String s, int index, char c){
		char[] chars = s.toCharArray();
		chars[index] = c;
		return s = new String(chars);     //string 类型初始化时候可以直接赋值char数组
									//把char数组作为String类的构造函数的参数
	}
    
}
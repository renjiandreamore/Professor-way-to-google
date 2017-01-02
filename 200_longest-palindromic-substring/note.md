```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/longest-palindromic-substring
@Language: Markdown
@Datetime: 16-11-09 17:32
```

新的解法：abcba这样的奇数个长度可由c左右推，看是否相等判断。但是abba这样偶数长度，我们没法找到b和b之间的那个数，所以思想是无论奇偶我们都把长度扩大一倍，扩大后的偶数各位用#表示，扩大后的奇数各位用原字符串string的从0-s.len-1的各个位置字符表示. 

abba --> #a#b#b#a ,后面再补一个#即可, 有效性是从第三个#开始左右移动判断。
abcba --> #a#b#c#b#a, 后面再补一个#即可，有效性是从c开始左右移动判断。

旧版本：
if(s.length() == 1) return s;
        
        String rs = "";
        int len = 0;
        for(int i = 0; i < s.length() ;i++){
            for(int j = i + 1; j <s.length(); j++) {
                if(isPalindrome(s, i, j)){
                    if(len < j - i + 1){
                        len = j - i + 1;
                        rs = s.substring(i, j+1);
                    }
                }
            }
        }
        
        return rs;
    }
    
    public boolean isPalindrome(String s, int st, int e){
        if(s == null || s.length() == 0){
            return false;
        }
        
        for(int i=st,j=e; i < j; i++,j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
		
		
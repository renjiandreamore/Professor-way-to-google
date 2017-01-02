```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/palindrome-partitioning
@Language: Markdown
@Datetime: 16-09-26 20:20
```

aab:
f(大魔法）:县从头开始，
1.以前一个元素开头(a) : 看a是否是回文， 是的话再从a的点开始递归调用helper， 看a之后的点是否是回文。递归调用f(大魔法)

2. 以前2个元素开头(aa): 看aa是否是回文，是的话再调用helper看之后是否是回文. 递归调用f(大魔法)



List<List<String>> res = new ArrayList<List<String>>();
        if(s == null){
            return res;
        }
        List<String> path = new ArrayList<String>();
        helper(res, path, s, 0);
        return res;
    }
    
    void helper(List<List<String>> res, List<String> path, String s, int pos){
        if(pos == s.length()){
            res.add(new ArrayList<String>(path));
            return;
        }
        
        for(int i = pos + 1; i <= s.length(); i++){
            String prefix = s.substring(pos, i);
            if(!isPalindrome(prefix)){
                continue;
            }
            
            path.add(prefix);
            helper(res, path, s, i);
            path.remove(path.size()-1);
        }
    }
    
    public boolean isPalindrome(String s){
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
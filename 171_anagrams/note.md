```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/anagrams
@Language: Markdown
@Datetime: 16-11-02 17:50
```

中心思想 ：  lint，intl， inlt...他们每个字母都一样，所以以他们字母组成的hash值的和是一样的


public int getHash(String str){
        int a = 378551;
        int b = 63689;
        int hash = 0;
        for(int i = 0; i < str.length();i++ ){
            hash = a*hash + str.charAt(i);
            a = a*b;
        }
        return hash;
 }
	
这个gethash是get一个独特单词的hash，lint 和 intl的hash不一样，看for里面的句子就知道了。

而我们现在要求即便顺序不同也要hash相同的结果， 那么只能把单词里的字母转化成int[]， 下标为字母，int[]里放的是字母出现的次数. 

这样不管顺序如何变化， 只要是anagram，每个字母出现的次数肯定一样多，于是hash也会一样.



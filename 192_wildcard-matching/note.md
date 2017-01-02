```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/wildcard-matching
@Language: Markdown
@Datetime: 16-10-20 18:46
```

 if(p.length()==0)  
        return s.length()==0;  
        boolean[] res = new boolean[s.length()+1];  
        res[0] = true;  
        for(int j=0;j<p.length();j++)  {  
            if(p.charAt(j)!='*')  {  
                for(int i=s.length()-1;i>=0;i--)  
                {  
                    res[i+1] = res[i]&&(p.charAt(j)=='?'||s.charAt(i)==p.charAt(j));  
                }  
            }  
        else  
        {  
            int i = 0;  
            while(i<=s.length() && !res[i])  
                i++;  
            for(;i<=s.length();i++)  
            {  
                res[i] = true;  
            }  
        }  
        res[0] = res[0]&&p.charAt(j)=='*';  
    }  
    return res[s.length()];  
     }
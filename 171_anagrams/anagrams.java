/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/anagrams
@Language: Java
@Datetime: 16-11-02 17:50
*/

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
     
     /*
     中心思想 ： lint，intl， inlt...
     他们每个字母都一样，所以以他们字母组成的hash值的和是一样的
     
     map < 101-<lint, intl,inlt>,  238-<code, deoc>, 111-<cant>>
     找map.get(hash) 或者 arr : map.values() > 1 
     的那几个hash值，然后把他们后面的list addAll到最终list的结果里面
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> res = new ArrayList<>();
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        
        if(strs == null || strs.length == 0){
            return res;
        }
        
        for(String str : strs){
            int[] hashLetter = new int[32];
            for(int i = 0; i < str.length();i++){
                hashLetter[str.charAt(i) - 'a']++ ;
            }
            int hash = getHash(hashLetter);
            if (!map.containsKey(hash)) {
               map.put(hash, new ArrayList<String>()); 
            }
            map.get(hash).add(str);
        }
        
        for(ArrayList<String> arr : map.values()){
            if(arr.size()>=2){
                res.addAll(arr);
            }
        }
        return res;
    }
    
    public int getHash(int[] num){
        int a = 378551; //123;    //the way how to calculate RSHash 
        int b = 63689; //45;
        int hash = 0;
        
        for(int i = 0; i < num.length;i++ ){
            hash = a*hash + num[i];
            a = a*b;
        }
        return hash;
    }
    
    
}
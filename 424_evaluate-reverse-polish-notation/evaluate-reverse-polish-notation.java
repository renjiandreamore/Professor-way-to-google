/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/evaluate-reverse-polish-notation
@Language: Java
@Datetime: 16-12-07 18:36
*/

public class Solution {
    /**
     * @param tokens The Reverse Polish Notation
     * @return the value
     */
    public int evalRPN(String[] tokens) {
        // Write your code here
        if(tokens == null || tokens.length == 0){
            return 0;
        }
        String operators = "+-*/";
        
        Stack<Integer> st = new Stack<>();
        
        for(String s: tokens){
            if(!operators.contains(s)){
                st.push(Integer.valueOf(s));
                continue;
            }
            
            int a = st.pop();
            int b = st.pop();
            if(s.equals("+")){
                st.push(b+a);
            }else if(s.equals("-")){
                st.push(b-a);
            }else if(s.equals("*")){
                st.push(b*a);
            }else{
                st.push(b/a);
            }
        }
        
        return st.pop();
    }
}

//
//                       _oo0oo_
//                      o8888888o
//                      88" . "88
//                      (| -_- |)
//                      0\  =  /0
//                    ___/`---'\___
//                  .' \\|     |// '.
//                 / \\|||  :  |||// \
//                / _||||| -:- |||||- \
//               |   | \\\  -  /// |   |
//               | \_|  ''\---/''  |_/ |
//               \  .-\__  '-'  ___/-. /
//             ___'. .'  /--.--\  `. .'___
//          ."" '<  `.___\_<|>_/___.' >' "".
//         | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//         \  \ `_.   \_ __\ /__ _/   .-` /  /
//     =====`-.____`.___ \_____/___.-`___.-'=====
//                       `=---='
//
//
//     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//
//               佛祖保佑         永无BUG
//
//
//
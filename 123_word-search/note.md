```
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/word-search
@Language: Markdown
@Datetime: 16-12-30 07:03
```




此版本在矩阵里有重复char的时候就不能用了

Map<Character, List<Character>> map = new HashMap<>();
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                List<Character> list = getNeighbors(board, i, j);
                map.put(board[i][j], list);
            }
        }
        
        for(int i = 0; i < word.length() - 1; i++ ){
            if(!map.containsKey(word.charAt(i))){
                return false;
            }else{
                if(!map.get(word.charAt(i)).contains(word.charAt(i+1))){
                    return false;
                }
            }
        }
        return true;
    }
    
    public List<Character> getNeighbors(char[][] f, int i, int j){
	        List<Character> list = new ArrayList<>();
	        if(i == 0 && j == 0){
	        	list.add(f[i][j+1]);
	        	list.add(f[i+1][j]);
	        }else if( i == 0 && j == f[0].length - 1){
	        	list.add(f[i][j-1]);
	        	list.add(f[i+1][j]);
	        }else if(i == 0){
	        	list.add(f[i][j-1]);
	        	list.add(f[i][j+1]);
	        	list.add(f[i+1][j]);
	        }else if(j == 0 && i == f.length-1){
	        	list.add(f[i-1][j]);
	        	list.add(f[i][j+1]);
	        }else if(j == 0 ){
	        	list.add(f[i-1][j]);
	        	list.add(f[i+1][j]);
	        	list.add(f[i][j+1]);
	        }else if(i == f.length - 1 && j == f[0].length - 1){
	        	list.add(f[i-1][j]);
	        	list.add(f[i][j-1]);
	        }else if( i == f.length - 1){
	        	list.add(f[i][j-1]);
	        	list.add(f[i][j+1]);
	        	list.add(f[i-1][j]);
	        }else if( j == f[0].length - 1){
	        	list.add(f[i-1][j]);
	        	list.add(f[i+1][j]);
	        	list.add(f[i][j-1]);
	        }else{
	        	list.add(f[i][j-1]);
	        	list.add(f[i][j+1]);
	        	list.add(f[i-1][j]);
	        	list.add(f[i+1][j]);
	        }
	        
	        return list;
/*
@Copyright:LintCode
@Author:   jian14
@Problem:  http://www.lintcode.com/problem/gfs-client
@Language: Java
@Datetime: 16-12-21 16:23
*/

/* Definition of BaseGFSClient
 * class BaseGFSClient {
 *     private Map<String, String> chunk_list;
 *     public BaseGFSClient() {}
 *     public String readChunk(String filename, int chunkIndex) {
 *         // Read a chunk from GFS
 *     }
 *     public void writeChunk(String filename, int chunkIndex,
 *                            String content) {
 *         // Write a chunk to GFS
 *     }
 * }
 */
public class GFSClient extends BaseGFSClient {
    public int chunkSize;
    public Map<String, Integer> map;

    public GFSClient(int chunkSize) {
        // initialize your data structure here
        this.chunkSize = chunkSize;
        this.map = new HashMap<String, Integer>();
    }
    
    // @param filename a file name
    // @return conetent of the file given from GFS
    public String read(String filename) {
        // Write your code here
        if(!map.containsKey(filename)){
            return null;
        } 
        
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < map.get(filename); i++) {
            String subCont = readChunk(filename, i);
            if(subCont != null){
                sb.append(subCont);
            }
        }
        
        return sb.toString();
    }

    // @param filename a file name
    // @param content a string
    // @return void
    public void write(String filename, String content) {
        // Write your code here
        int length = content.length();
        
        int num = (length - 1)/ chunkSize  + 1;
        map.put(filename, num);    // < a.txt, 3>  a.txt has 3 chunks
        
        for(int i = 0; i < num; i++){
            int start = i * chunkSize;
            int end = i == num -1 ? length : (i+1) * chunkSize;
            String sub_content = content.substring(start, end);
            writeChunk(filename, i, sub_content);
        }
    }
}
import java.util.ArrayList;
import java.util.HashMap;

public class demo3 {
    public ArrayList<String> GetSpaceUsageMaxDir (String queryDir, String[] filePathList, long[] fileSizeList) {
        // write code here
        // 1、先找到queryDir下有哪些文件、以及对应文件大小
        // 如果是file、直接计算 ； 如果dir，需要累加求和
        // 2、文件大小最大的那个路径
        HashMap<String, Long> dir_size = new HashMap<>();
        HashMap<String, ArrayList<String>> dir_files = new HashMap<>();
        ArrayList<String> dir_key = new ArrayList<>();
        
        for(int i=0; i<filePathList.length; i++){
            String cur_dir = filePathList[i];
            if(cur_dir.startsWith(queryDir)){
                String inner_dir = cur_dir.substring(queryDir.length());
                String[] dirs = inner_dir.split("/");
                // 一级路径/文件 作为key
                String key = dirs[1];
                dir_key.add(key);
                if(dirs.length>2){
                    // 是文件夹
                    if(dir_size.containsKey(key)){
                        dir_size.put(key, dir_size.get(key) + fileSizeList[i]);
                        dir_files.get(key).add(cur_dir);
                    }else{
                        dir_size.put(key, dir_size.get(key));
                        ArrayList<String> list = new ArrayList<>();
                        list.add(cur_dir);
                        dir_files.put(key, list);
                    }
                }else{
                    // 是文件
                    dir_size.put(key, dir_size.get(key));
                    ArrayList<String> list = new ArrayList<>();
                    list.add(cur_dir);
                    dir_files.put(key, list);
                }
                
            }
        }

        Long max = -1L;
        String maxKey = "";
        for(int i=0; i<dir_key.size(); i++){
            String key = dir_key.get(i);
            Long size = dir_size.get(key);
            if(size>max){
                maxKey = key;
                max = size;
            }
        }

        return dir_files.get(maxKey);
    }

    public boolean isDir(String cur_dir){
        return cur_dir.startsWith("/dir");
    }
}

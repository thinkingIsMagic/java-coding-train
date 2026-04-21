import java.util.HashMap;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class demo2{
    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // // 注意 hasNext 和 hasNextLine 的区别
        // while (in.hasNextInt()) { // 注意 while 处理多个 case
        //     int a = in.nextInt();
        //     int b = in.nextInt();
        //     System.out.println(a + b);
        // }

        String queryDir = "/dir_1";
        String cur_dir = "/dir_1/file_1";
        String inner_dir = cur_dir.substring(queryDir.length());
        System.out.println(inner_dir);
        System.out.println(isDir(inner_dir));
        String[] res = inner_dir.split("/");
        for(int i=0; i<res.length; i++){
            System.out.println(res[i]);
        }
        System.out.println(res.length);

        HashMap<String, Long> dir_size = new HashMap<>();
        dir_size.put("a",1L);
        Long max = -1L;
        String maxKey;
        // dir_size.forEach((String key, Long val)->{
        //     if(val>max){
        //         maxKey = key;
        //         max = val;
        //     }
        // });

    }

    public static boolean isDir(String cur_dir){
        return cur_dir.startsWith("/dir");
    }
}
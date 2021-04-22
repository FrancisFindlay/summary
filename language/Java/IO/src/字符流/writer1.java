package 字符流;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class writer1 {
    public static void main(String[] args) throws IOException {
        File file=new File("/users/Francis/desktop/demo1.txt");
        Writer writer=null;
        try {
            writer=new FileWriter(file,true);
            writer.write("哈哈哈哈\r");//mac下为\r,windows为\n\r
            
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(writer!=null){
                try{
                    //文件流在关闭前会flush（），清空缓存;
                    writer.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

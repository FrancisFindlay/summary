package 字符流和字节流转换;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class ConvertClass {
    public static void main(String[] args) {
        OutputStreamWriter ow=null;
        //字符流转换为字节流
        try{
            ow=new OutputStreamWriter(new FileOutputStream("b.txt",true),"utf-8");
            ow.write("中");
            ow.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                ow.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

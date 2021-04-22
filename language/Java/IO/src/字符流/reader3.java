package 字符流;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class reader3 {
    public static void main(String[] args) {
        File file=new File("/users/Francis/desktop/demo1.txt");
        Reader reader=null;
        try {
            reader=new FileReader(file);
            char cs[]=new char[10];
            int len=reader.read(cs);//读取的长度
            System.out.println(len);
            System.out.println(cs);

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(reader!=null){
                try {
                    reader.close();
                }catch (IOException e1){
                    e1.printStackTrace();
                }
            }
        }
    }
}

package 字符流;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class reader2 {
    public static void main(String[] args) {
        File file=new File("/users/Francis/desktop/demo1.txt");
        Reader reader=null;
        try {
            reader=new FileReader(file);
            int c=-1;
            while((c=reader.read())!=-1){
                System.out.print((char)c);
            }

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

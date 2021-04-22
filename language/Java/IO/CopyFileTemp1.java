package 字符流;

import java.io.*;

public class reader1 {
    public static void main(String[] args) {
        File file=new File("/users/Francis/desktop/demo1.txt");
        Reader reader=null;
        try {
            reader=new FileReader(file);
            int c=reader.read();//读取的字符被转换成为asc码
            System.out.println((char)c);

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

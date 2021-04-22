package 字符流;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) {
        File file=new File("src/字符流/reader1.java");
        File fileCopy=new File("CopyFileTemp.java");
        Reader reader=null;
        Writer writer=null;
        try {
            writer=new FileWriter(fileCopy);
            reader=new FileReader(file);
            char []cs=new char[1024];
            int len=-1;
            while((len=reader.read(cs))!=-1){
                writer.write(cs,0,len);
            }
            writer.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(reader!=null){
                try {
                    writer.close();//后开先关闭
                    reader.close();
                }catch (IOException e1){
                    e1.printStackTrace();
                }
            }
        }
    }
}

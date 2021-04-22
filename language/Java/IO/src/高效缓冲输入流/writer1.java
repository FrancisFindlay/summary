package 高效缓冲输入流;

import java.io.*;

public class writer1 {
    public static void main(String[] args) {
        BufferedWriter writer=null;
        try{
            writer=new BufferedWriter(new FileWriter("write.txt"));
            writer.write("abcedfas");
            writer.newLine();
            writer.write("asdasdasd");
            writer.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(writer!=null){
                try{
                    writer.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}

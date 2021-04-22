package 高效缓冲输入流;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class reader2 {
    public static void main(String[] args) {
        BufferedReader reader=null;
        try{
            reader=new BufferedReader(new FileReader("CopyFileTemp.java"));
            String s=null;
            while((s=reader.readLine())!=null){
                System.out.println(s);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(reader!=null){
                try{
                    reader.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}

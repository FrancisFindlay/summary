package 字节流;

import java.io.*;

public class reader {

    public static void main(String[] args) {
        InputStream in=null;
        try{
            in=new FileInputStream("a.txt");
            int r=in.read();
            System.out.println((char)r);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(in!=null){
                try {
                    in.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

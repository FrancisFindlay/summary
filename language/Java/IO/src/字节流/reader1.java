package 字节流;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class reader1 {

    public static void main(String[] args) {
        InputStream in=null;
        try{
            byte b[]=new byte[6];
            in=new FileInputStream("a.txt");
            int len=in.read(b);
            System.out.println(new String(b,0,len));
            in.read(b);
            System.out.println(new String(b,0,len));
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

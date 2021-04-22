package 字节流;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class reader2 {

    public static void main(String[] args) {
        InputStream in=null;
        try{
            byte b[]=new byte[1024];
            in=new FileInputStream("a.txt");
            int flag=-1;
            while((flag=in.read(b))!=-1){
                String s=new String(b,0,flag);
                System.out.println(s);
            }
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

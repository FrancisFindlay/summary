package 字节流;

import java.io.*;

public class readerCopy {

    public static void main(String[] args) {
        InputStream in=null;
        OutputStream out=null;
        try{
            in=new FileInputStream("/users/Francis/desktop/demo1.txt");
            out=new FileOutputStream("b.txt");
            byte[] b=new byte[1024];
            int flag=-1;
            while((flag=in.read())!=-1){
                out.write(b,0,flag);

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
            if(out!=null){
                try {
                    out.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}

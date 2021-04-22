package 字节流;

import java.io.*;

public class BufferedInput {

    public static void main(String[] args) {
        BufferedInputStream in=null;
        BufferedOutputStream out=null;

        try{
            byte b[]=new byte[1024];
            in=new BufferedInputStream(new FileInputStream("a.txt"));
            out=new BufferedOutputStream(new FileOutputStream("b.txt"));
            int flag=-1;
            while((flag=in.read(b))!=-1){
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
        }
    }
}

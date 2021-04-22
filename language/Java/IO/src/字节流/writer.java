package 字节流;

import java.io.*;
import java.util.stream.Stream;

public class writer {

    public static void main(String[] args) {
        OutputStream out=null;
        try{
            byte[] b=new byte[]{97,99,100,101};
            out=new FileOutputStream("a.txt",true);
            out.write(b,1,2);
            //不需要flush（);
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }
}

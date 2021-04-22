package Properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

public class demo3 {
    public static void main(String[] args) {
        Properties pro=new Properties();
        FileInputStream in=null;
        try{
            in=new FileInputStream("name.txt");
            pro.load(in);
            System.out.println(pro);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(in!=null){
                try {
                    in.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}

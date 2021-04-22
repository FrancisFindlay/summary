package Properties;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class demo4 {
    public static void main(String[] args) {
        Properties pro=new Properties();
        InputStream in=null;
        try{
            in=demo4.class.getClassLoader().getResourceAsStream("name.Properties");
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

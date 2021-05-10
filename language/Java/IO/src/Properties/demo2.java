package Properties;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

public class demo2 {
    public static void main(String[] args) {
        Properties pro = new Properties();
        pro.setProperty("1", "p1");
        pro.setProperty("2", "p2");
        PrintWriter print = null;
        try {
            print = new PrintWriter("name.properties");
            pro.store(print, "with store");//注释
            print.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (print != null) {
                try {
                    print.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package Properties;

import java.util.Properties;

public class demo1 {
    public static void main(String[] args) {
        Properties pro = new Properties();
        pro.setProperty("1", "p1");
        pro.setProperty("2", "p2");
        System.out.println(pro);
        String name1 = pro.getProperty("1");
        System.out.println("name1");
    }
}

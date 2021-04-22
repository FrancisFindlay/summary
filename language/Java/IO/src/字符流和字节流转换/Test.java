package 字符流和字节流转换;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s=new String("中");
        byte []b=s.getBytes("utf-8");
        System.out.println(Arrays.toString(b));
    }
}

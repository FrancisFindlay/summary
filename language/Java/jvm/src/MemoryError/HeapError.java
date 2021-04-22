package MemoryError;

import java.util.ArrayList;
import java.util.List;

/*
 * -Xms20M  堆最小值
 * -Xmx20M  堆最大值
 *  -XX:+HeapDumpOnOutOfMemoryError 输出内存信息
 *
 */
public class HeapError {
    static class Inner {

    }
    public static void main(String[] args) {
        List<Inner> list = new ArrayList<>();
        int i = 1;
        while(true) {
            System.out.println(i++);
            list.add(new Inner());
        }
    }
}

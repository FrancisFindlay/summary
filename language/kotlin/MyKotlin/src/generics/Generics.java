package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;




public class Generics {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add("String");
        List<? extends Object> list = strs;
        // list.add("string"); 只能读取不能写入, 报错。
        System.out.println(list.get(0));
        // List<Object> list0 = strs; 报错
        List<? super String> list1 = new ArrayList<>();
        list1.add("string");
        System.out.println(list1.get(0).getClass().getTypeName());
        List<? super String> list2 = strs;
        System.out.println(list2.get(0).getClass().getTypeName());

        /*
        对于 List <? super String> 你只能调用接受 String 作为参数的方法 (例如，你可以调用 add(String) 或者 set(int, String) )
        ，当然如果调用函数返回 List<T> 中的 T ，你得到的并非一个 String 而是一个 Object 。

        只能从中读取的对象为生产者，并称那些你只能写入的对象为消费者。
         */
    }

    public static void copyAll(Collection<Object> to, Collection<String> from) {
        to.addAll(from);
    }
}

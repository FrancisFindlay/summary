package com.example.ch2;

/**
 * FLoat舍入和误差的几个case
 */

public class Test {
    public static void main(String[] args) {
        System.out.println((-7  + (1 << 1) -1) >> 1);
        System.out.println(1E10 + 3.14 - 1E10);
        System.out.println((3.14F + 1E10F) - 1E10F);
        System.out.println(3.14 + (1E10 - 1E10));
        int v = (1 << 26) + 1;
        float f = (float)v;
        System.out.println(v);
        System.out.println(f);

        // 有关移位
        int x = -1;
        x = x >>> 1; // 逻辑右移，忽略符号位，高位补0
        //01111 1111 1111 1111  ... 111
        System.out.println(x >>> 1);

    }
}

package MemoryError;

public class StringTest {
    public static void main(String[] args) {
        String a = "a";
        String aa = "a";
        String b = "b";
        String c = "ab";
        if (c == a + b) {
            System.out.println("yes");
        }
    }
}

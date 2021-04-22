package MemoryError;

/*
 * -Xss128K 设置栈的最大容量
 */
public class StackError {
    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        StackError s = new StackError();
        try {
            s.stackLeak();
        }catch (Throwable e){
            System.out.println(s.stackLength);
        }
    }
}

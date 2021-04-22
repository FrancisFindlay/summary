package 字符流;

import java.io.*;
import java.util.LinkedList;

class Solution {
    public static boolean isValid(String s) {
        LinkedList stack=new LinkedList();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')'){
                if(stack.peekFirst().equals("("))
                    stack.pollFirst();
            }else if(s.charAt(i)=='}'){
                if(stack.peekFirst().equals("{"))
                    stack.pollFirst();
            }else if(s.charAt(i)==']'){
                if(stack.peekFirst().equals("["))
                    stack.pollFirst();

            }else{
                stack.addFirst(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
public class reader1 {
    public static void main(String[] args) {
        Solution.isValid("()");
    }
}

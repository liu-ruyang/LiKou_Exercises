package org.example.hot100.stack;

import java.util.LinkedList;

public class Question20 {
    public static void main(String[] args) {
        new Question20().isValid("(){}}{");
    }

    public boolean isValid(String s) {
        if (s.equals("")) {
            return true;
        }
        LinkedList<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == 0 || chars[i] == '(' || chars[i] == '[' || chars[i] == '{' || chars[i] == ')' && (stack.isEmpty() || stack.peek() != '(') || chars[i] == ']' && (stack.isEmpty() || stack.peek() != '[') || chars[i] == '}' && (stack.isEmpty() || stack.peek() != '{')) {
                stack.push(chars[i]);
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}

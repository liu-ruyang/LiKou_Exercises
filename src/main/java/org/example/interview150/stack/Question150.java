package org.example.interview150.stack;

import java.util.Deque;
import java.util.LinkedList;

public class Question150 {
    public static void main(String[] args) {
        String[] a = {"2", "1", "+", "3", "*"};
        new Question150().evalRPN(a);
    }

    public int evalRPN(String[] tokens) {
        Deque deque = new LinkedList<>();

        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    deque.push((int) deque.pop() + (int) deque.pop());
                }
                case "-" -> {
                    int a = (int) deque.pop();
                    int b = (int) deque.pop();
                    deque.push(b - a);
                }
                case "*" -> {
                    deque.push((int) deque.pop() * (int) deque.pop());
                }
                case "/" -> {
                    int a = (int) deque.pop();
                    int b = (int) deque.pop();
                    deque.push(b / a);
                }
                default -> {
                    deque.push(Integer.valueOf(token));
                }
            }
        }
        return (int) deque.pop();
    }
}

package org.example.interview150.stack;

import java.util.Deque;
import java.util.LinkedList;

public class Questin224 {

    public static void main(String[] args) {
        new Questin224().calculate("- (3 + (4 + 5))");
    }

    public int calculate(String s) {
        Deque op = new LinkedList<>();
        Deque nums = new LinkedList<Integer>();

        String[] tokens = ("(" + s + ")").replaceAll(" ", "")
                .replace("(", " ( ")
                // .replace("(", "")
                .replace(")", " ) ")
                // .replace(")", "")
                .replace("+", " + ")
                .replace("-", " - ")
                // .replace("*", " * ")
                // .replace("/", " / ")
                .split(" ");

        // String lastOp = "+";

        int sum = 0;
        // for (String token : tokens) {
        //     if (token.equals("")) {
        //         continue;
        //     } else if (lastOp.equals("-") && token.equals("-")) {
        //         lastOp = "+";
        //     } else if (token.equals("-")) {
        //         lastOp = "-";
        //     } else {
        //         if (lastOp.equals("-")) {
        //             sum -= Integer.valueOf(token);
        //             lastOp = "+";
        //         } else if (!token.equals("+")) {
        //             sum += Integer.valueOf(token);
        //         }
        //     }
        // }
        //
        // return sum;

        // for (String token : tokens) {
        //     if (token.equals("(")) {
        //         deque.add(token);
        //     }
        //     if (token.equals("+") || token.equals("-")) {
        //         op.add(token);
        //     }
        // }

        for (String token : tokens) {
            if (!token.equals("")) {
                if (token.equals("(") || token.equals("-") || token.equals("+")) {
                    op.push(token);
                } else if (token.equals(")")) {
                    char c = (char) op.pop();
                    while (c != '(') {
                        switch (c) {
                            case '-' -> {

                            }
                            case '+' -> {

                            }
                        }
                        c = (char) op.pop();
                    }

                } else {
                    nums.push(Integer.valueOf(token));
                }
            }
        }

        // for (char c : s.toCharArray()) {
        //     if (c == ')') {
        //         char c2 = (char) deque.pop();
        //         while (c2 != '(') {
        //
        //
        //             c2 = (char) deque.pop();
        //         }
        //
        //     } else {
        //         deque.push(c);
        //     }
        // }
        return 0;
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

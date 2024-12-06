package org.example.interview150.stack;

import java.util.LinkedList;

public class Questin224 {

    public static void main(String[] args) {
        // new Questin224().calculate("(1+(4+5+2)-3)+(6+8)");
        new Questin224().calculate("0");
    }

    public int calculate(String s) {
        String s1 = "(" + s + ")";
        String[] tokens = s1
                .replace("(", " ( ")
                // .replace("(", "")
                .replace(")", " ) ")
                // .replace(")", "")
                .replace("+", " + ")
                .replace("-", " - ")
                .trim()
                .split("\\s+");

        LinkedList<String> stack = new LinkedList<>();
        for (String token : tokens) {
            if (!token.equals(")")) {
                stack.push(token);
            } else {
                int sum = 0;
                int num = Integer.valueOf(stack.pop());
                // String op = stack.pop();
                String op = stack.pop();
                
                if (op.equals("(")) {
                    stack.push(num + "");
                }

                while (!op.equals("(")) {
                    if (op.equals("-")) {
                        sum -= num;
                    } else if (op.equals("+")) {
                        sum += num;
                    }

                    if (stack.peek().equals("(")) {
                        stack.pop();
                        stack.push(sum + "");
                        break;
                    }

                    num = Integer.valueOf(stack.pop());
                    op = stack.pop();

                    if (op.equals("(")) {
                        sum += num;
                        stack.push(sum + "");
                        break;
                    }
                }
            }
        }
        return Integer.valueOf(stack.pop());
    }
    // public int calculate(String s) {
    //     String[] tokens = ("(" + s + ")").replaceAll(" ", "")
    //             .replace("(", " ( ")
    //             // .replace("(", "")
    //             .replace(")", " ) ")
    //             // .replace(")", "")
    //             .replace("+", " + ")
    //             .replace("-", " - ")
    //             .split(" ");
    //
    //     // 操作符栈
    //     LinkedList<String> opStack = new LinkedList<>();
    //     // 操作数栈
    //     LinkedList<Integer> numStack = new LinkedList<>();
    //
    //     for (String token : tokens) {
    //         if (token.equals("(") || token.equals("-") || token.equals("+")) {
    //             opStack.push(token);
    //         } else if (token.equals(")")) {
    //             int num = 0;
    //             String op = opStack.pop();
    //             while (!op.equals("(")) {
    //                 switch (op) {
    //                     case ("+") -> {
    //                         num += numStack.pop();
    //                     }
    //                     case ("-") -> {
    //                         num -= numStack.pop();
    //                     }
    //                 }
    //                 op = opStack.pop();
    //             }
    //             numStack.push(num);
    //
    //         } else {
    //             numStack.push(Integer.valueOf(token));
    //         }
    //     }
    //
    // }

    // public int calculate(String s) {
    //     Deque op = new LinkedList<>();
    //     Deque nums = new LinkedList<Integer>();
    //
    //     String[] tokens = ("(" + s + ")").replaceAll(" ", "")
    //             .replace("(", " ( ")
    //             // .replace("(", "")
    //             .replace(")", " ) ")
    //             // .replace(")", "")
    //             .replace("+", " + ")
    //             .replace("-", " - ")
    //             // .replace("*", " * ")
    //             // .replace("/", " / ")
    //             .split(" ");
    //
    //     // String lastOp = "+";
    //
    //     int sum = 0;
    //     // for (String token : tokens) {
    //     //     if (token.equals("")) {
    //     //         continue;
    //     //     } else if (lastOp.equals("-") && token.equals("-")) {
    //     //         lastOp = "+";
    //     //     } else if (token.equals("-")) {
    //     //         lastOp = "-";
    //     //     } else {
    //     //         if (lastOp.equals("-")) {
    //     //             sum -= Integer.valueOf(token);
    //     //             lastOp = "+";
    //     //         } else if (!token.equals("+")) {
    //     //             sum += Integer.valueOf(token);
    //     //         }
    //     //     }
    //     // }
    //     //
    //     // return sum;
    //
    //     // for (String token : tokens) {
    //     //     if (token.equals("(")) {
    //     //         deque.add(token);
    //     //     }
    //     //     if (token.equals("+") || token.equals("-")) {
    //     //         op.add(token);
    //     //     }
    //     // }
    //
    //     for (String token : tokens) {
    //         if (!token.equals("")) {
    //             if (token.equals("(") || token.equals("-") || token.equals("+")) {
    //                 op.push(token);
    //             } else if (token.equals(")")) {
    //                 char c = (char) op.pop();
    //                 while (c != '(') {
    //                     switch (c) {
    //                         case '-' -> {
    //
    //                         }
    //                         case '+' -> {
    //
    //                         }
    //                     }
    //                     c = (char) op.pop();
    //                 }
    //
    //             } else {
    //                 nums.push(Integer.valueOf(token));
    //             }
    //         }
    //     }
    //
    //     // for (char c : s.toCharArray()) {
    //     //     if (c == ')') {
    //     //         char c2 = (char) deque.pop();
    //     //         while (c2 != '(') {
    //     //
    //     //
    //     //             c2 = (char) deque.pop();
    //     //         }
    //     //
    //     //     } else {
    //     //         deque.push(c);
    //     //     }
    //     // }
    //     return 0;
    // }
    //
    // public int evalRPN(String[] tokens) {
    //     Deque deque = new LinkedList<>();
    //
    //     for (String token : tokens) {
    //         switch (token) {
    //             case "+" -> {
    //                 deque.push((int) deque.pop() + (int) deque.pop());
    //             }
    //             case "-" -> {
    //                 int a = (int) deque.pop();
    //                 int b = (int) deque.pop();
    //                 deque.push(b - a);
    //             }
    //             case "*" -> {
    //                 deque.push((int) deque.pop() * (int) deque.pop());
    //             }
    //             case "/" -> {
    //                 int a = (int) deque.pop();
    //                 int b = (int) deque.pop();
    //                 deque.push(b / a);
    //             }
    //             default -> {
    //                 deque.push(Integer.valueOf(token));
    //             }
    //         }
    //     }
    //     return (int) deque.pop();
    // }
}

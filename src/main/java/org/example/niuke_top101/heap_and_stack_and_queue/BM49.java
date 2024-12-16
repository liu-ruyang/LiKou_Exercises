package org.example.niuke_top101.heap_and_stack_and_queue;

import java.util.LinkedList;

public class BM49 {
    public static void main(String[] args) {
        // new BM49().solve("1+2");
        // new BM49().solve("(2*(3-4))*5");
        // new BM49().solve("((10+2)*10-(100-(10+20*10-(2*3)))*10*1*2)-2");
        // new BM49().solve("(3+4)*(5+(2-3))");
        // new BM49().solve("1-2-3");
        new BM49().solve("1-(     -2)");
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 返回表达式的值
     *
     * @param s string字符串 待计算的表达式
     * @return int整型
     */
    public int solve(String s) {
        // write code here
        String s1 = "(" + s + ")";
        String[] tokens = s1
                .replace("(", " ( ")
                .replace(")", " ) ")
                .replace("*", " * ")
                .replace("+", " + ")
                .replace("-", " - ")
                .trim()
                .split("\\s+");
        LinkedList<Integer> num = new LinkedList();
        LinkedList<String> opt = new LinkedList();
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]) {
                case "(":
                    opt.push("(");
                    break;
                case ")":
                    // while (!opt.isEmpty() && opt.peek() != "(") {
                    while (opt.peek() != "(") {

                        String optt = opt.pop();
                        if (optt == "+") {
                            num.push(num.pop() + num.pop());
                        } else if (optt == "-") {
                            num.push(-num.pop() + num.pop());
                        } else {
                            num.push(num.pop() * num.pop());
                        }
                    }
                    opt.pop();
                    break;
                case "*":
                    if (!tokens[i + 1].equals("(")) {
                        int left = num.pop();
                        int right = Integer.valueOf(tokens[++i]);
                        num.push(left * right);
                    } else {
                        opt.push("*");
                    }
                    break;
                case "+":
                    opt.push("+");
                    break;
                case "-":
                    // if (tokens[i - 1] == "(") {
                    if (!tokens[i + 1].equals("(")) {
                        int right = -Integer.valueOf(tokens[++i]);
                        num.push(right);
                        opt.push("+");
                    } else {
                        opt.push("-");
                    }
                    break;
                default:
                    num.push(Integer.valueOf(tokens[i]));
                    break;
            }
        }

        return num.pop();
    }
}

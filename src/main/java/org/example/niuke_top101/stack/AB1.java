package org.example.niuke_top101.stack;

import java.util.LinkedList;
import java.util.Scanner;

public class AB1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        in.nextLine();

        LinkedList stack = new LinkedList<Integer>();
        while (n > 0) {
            String cmd = in.nextLine();
            String[] str = cmd.split(" ");
            switch (str[0]) {
                case "push":
                    push(stack, Integer.valueOf(str[1]));
                    break;
                case "pop":
                    if (stack.isEmpty()) System.out.println("error");
                    else {
                        int val = pop(stack);
                        System.out.println(val);
                    }
                    break;
                case "top":
                    if (stack.isEmpty()) System.out.println("error");
                    else {
                        int val = top(stack);
                        System.out.println(val);
                    }
                    break;
            }
            n--;
        }
    }

    public static void push(LinkedList stack, int val) {
        stack.push(val);
    }

    public static int pop(LinkedList stack) {
        return (int) stack.pop();
    }

    public static int top(LinkedList stack) {
        return (int) stack.getFirst();
    }
}

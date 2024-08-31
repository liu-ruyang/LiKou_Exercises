package org.example.other;

/**
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 */
public class Question705 {
    public static void main(String[] args) {
        MyHashSet myHashSet = new Question705().new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1));
        // myHashSet.contains(1); // 返回 True
        System.out.println(myHashSet.contains(3));
        // myHashSet.contains(3); // 返回 False ，（未找到）
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2));
        // myHashSet.contains(2); // 返回 True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2));
        // myHashSet.contains(2); // 返回 False ，（已移除）

    }

    class MyHashSet {
        static int base = 1000001;

        MyNode[] myNodes;

        public MyHashSet() {
            myNodes = new MyNode[base];
        }

        public void add(int key) {
            MyNode newMyNode = myNodes[key];
            if (newMyNode == null) {
                MyNode node = new MyNode();
                myNodes[key] = node;
            }
            // MyNode node = new MyNode();
            // node.next = myNodes[key];
            // myNodes[key] = node;
        }

        public void remove(int key) {
            MyNode newMyNode = myNodes[key];
            if (newMyNode == null) {
                return;
            }
            myNodes[key] = newMyNode.next;
        }

        public boolean contains(int key) {
            MyNode newMyNode = myNodes[key];
            return newMyNode != null;
        }

        class MyNode {
            MyNode next;
        }
    }
}

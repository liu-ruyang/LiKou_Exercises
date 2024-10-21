package org.example.interview150.binary_tree;

import java.util.LinkedList;

public class Question117 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        
        LinkedList<NodeLevel> nodeLevels = new LinkedList<>();
        NodeLevel nodeLevel = new NodeLevel(root, 1);
        nodeLevels.add(nodeLevel);


        while (!nodeLevels.isEmpty()) {
            NodeLevel pop = nodeLevels.pop();
            if (pop.node.left != null) {
                nodeLevels.add(new NodeLevel(pop.node.left, pop.level + 1));
            }
            if (pop.node.right != null) {
                nodeLevels.add(new NodeLevel(pop.node.right, pop.level + 1));
            }
            if (!nodeLevels.isEmpty() && nodeLevels.peek().level == pop.level) {
                pop.node.next = nodeLevels.peek().node;
            }
        }

        return root;
    }

    class NodeLevel {
        Node node;
        int level;

        public NodeLevel(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}

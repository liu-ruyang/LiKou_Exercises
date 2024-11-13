package org.example.interview150.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Question133 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        // 为了防止多次遍历同一个节点，陷入死循环，我们需要用一种数据结构记录已经被克隆过的节点。
        HashMap<Node, Node> map = new HashMap<>();

        Node cloneNode = new Node(node.val);
        cloneNode.neighbors = new ArrayList<Node>();
        map.put(node, cloneNode);
        bfsClone(node, cloneNode, map);
        return cloneNode;
    }

    public void bfsClone(Node node, Node cloneNode, HashMap map) {
        for (Node neighbor : node.neighbors) {
            if (!map.containsKey(neighbor)) {
                Node clone = new Node(neighbor.val, new ArrayList<Node>());
                map.put(neighbor, clone);
                cloneNode.neighbors.add(clone);
                bfsClone(neighbor, clone, map);
            } else {
                cloneNode.neighbors.add((Node) map.get(neighbor));
            }
        }
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}

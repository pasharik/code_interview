package ru.pasharik.chapter_4_trees_graphs.question_4_1;

import java.util.LinkedList;
import java.util.Queue;

public class GraphUtils {
    private static class BinaryNodeWrapper {
        int level;
        public BinaryNode node;
        public BinaryNodeWrapper left;
        public BinaryNodeWrapper right;
    }

    private static BinaryNodeWrapper buildWrapperTree(BinaryNode head) {
        return fillWrapperTree(head, 0);
    }

    private static BinaryNodeWrapper fillWrapperTree(BinaryNode node, int level) {
        if (node == null) return null;
        BinaryNodeWrapper w = new BinaryNodeWrapper();
        w.level = level;
        w.node = node;
        if (node.left != null) w.left = fillWrapperTree(node.left, level + 1);
        if (node.right != null) w.right = fillWrapperTree(node.right, level + 1);
        return w;
    }

    /* Acyclic graph - binary tree */
    public static void printBinaryTree(BinaryNode node) {
        BinaryNodeWrapper wrapperHead = buildWrapperTree(node);

        Queue<BinaryNodeWrapper> q = new LinkedList<>();
        q.add(wrapperHead);
        int level = 0;
        while (!q.isEmpty()) {
            BinaryNodeWrapper n = q.remove();
            if (n.level > level) {
                System.out.println();
                level++;
            }
            System.out.print(n.node.value + " ");
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
    }
}

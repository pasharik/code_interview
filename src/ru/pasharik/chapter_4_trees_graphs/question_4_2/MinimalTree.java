package ru.pasharik.chapter_4_trees_graphs.question_4_2;

import ru.pasharik.chapter_4_trees_graphs.question_4_1.BinaryNode;
import ru.pasharik.chapter_4_trees_graphs.question_4_1.GraphUtils;
import ru.pasharik.chapter_4_trees_graphs.question_4_6.BinaryNodeParent;

public class MinimalTree {

    private BinaryNode process(int[] a, BinaryNode parent, int from, int to) {
         if (from > to) return null;
         int middleIndex = middle(from, to);
         BinaryNode n = createNode(parent);
         n.value = a[middleIndex];
         n.left = process(a, n, from, middleIndex - 1);
         n.right = process(a, n, middleIndex + 1, to);
         return n;
    }

    private int middle(int from, int to) {
        return from + (to - from) / 2;
    }

    protected BinaryNode createNode(BinaryNode parent) {
        BinaryNode n = new BinaryNodeParent();
        ((BinaryNodeParent) n).parent = parent;
        return n;
    }

    public static BinaryNode create(int[] arr) {
        return new MinimalTree().process(arr, null, 0, arr.length - 1);
    }

    private void doStart() {
        BinaryNode head = create(new int[]{0, 1, 3, 5, 7, 8, 9, 13, 18, 22});
        GraphUtils.printBinaryTree(head);
    }

    public static void main(String[] args) {
        new MinimalTree().doStart();
    }
}

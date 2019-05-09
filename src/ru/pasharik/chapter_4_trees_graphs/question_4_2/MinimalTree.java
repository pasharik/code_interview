package ru.pasharik.chapter_4_trees_graphs.question_4_2;

import ru.pasharik.chapter_4_trees_graphs.question_4_1.BinaryNode;
import ru.pasharik.chapter_4_trees_graphs.question_4_1.GraphUtils;

public class MinimalTree {

    private BinaryNode process(int[] a, int from, int to) {
         if (from > to) return null;
         int middleIndex = middle(from, to);
         BinaryNode n = new BinaryNode();
         n.value = a[middleIndex];
         n.left = process(a, from, middleIndex - 1);
         n.right = process(a, middleIndex + 1, to);
         return n;
    }

    private int middle(int from, int to) {
        return from + (to - from) / 2;
    }

    public static BinaryNode create(int[] arr) {
        return new MinimalTree().process(arr, 0, arr.length - 1);
    }

    private void doStart() {
        BinaryNode head = create(new int[]{0, 1, 3, 5, 7, 8, 9, 13, 18, 22});
        GraphUtils.printBinaryTree(head);
    }

    public static void main(String[] args) {
        new MinimalTree().doStart();
    }
}

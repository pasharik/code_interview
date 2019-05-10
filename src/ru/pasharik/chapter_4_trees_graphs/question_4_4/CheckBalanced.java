package ru.pasharik.chapter_4_trees_graphs.question_4_4;

import ru.pasharik.chapter_4_trees_graphs.question_4_1.BinaryNode;
import ru.pasharik.chapter_4_trees_graphs.question_4_1.GraphUtils;
import ru.pasharik.chapter_4_trees_graphs.question_4_2.MinimalTree;

import java.util.concurrent.atomic.AtomicBoolean;

public class CheckBalanced {
    // get height of left subtree
    // get height of right subtree
    // if difference in height > 1
    //    set flag = false
    // return max(hLeft, hRight) + 1
    private int process(BinaryNode n, AtomicBoolean flag) {
        if (n == null) return 0;
        int hLeft = process(n.left, flag);
        int hRight = process(n.right, flag);
        if (Math.abs(hLeft - hRight) > 1) flag.set(false);
        return Math.max(hLeft, hRight) + 1;
    }

    private void doStart(BinaryNode head) {
        AtomicBoolean isBalanced = new AtomicBoolean(true);
        process(head, isBalanced);
        System.out.println("Balanced: " + isBalanced.get());
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 2, 4, 5, 7, 8, 9, 13, 19};
        BinaryNode head = MinimalTree.create(arr);
        new CheckBalanced().doStart(head);
        GraphUtils.printBinaryTree(head);

        //Unbalance
        System.out.println();
        System.out.println();
        BinaryNode b = head;
        while (b.left != null) { b = b.left; }
        b.left = new BinaryNode();
        b = b.left;
        b.left = new BinaryNode();
        new CheckBalanced().doStart(head);
        GraphUtils.printBinaryTree(head);
    }
}

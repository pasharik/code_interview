package ru.pasharik.chapter_4_trees_graphs.question_4_4;

import ru.pasharik.chapter_4_trees_graphs.question_4_1.BinaryNode;
import ru.pasharik.chapter_4_trees_graphs.question_4_1.GraphUtils;
import ru.pasharik.chapter_4_trees_graphs.question_4_2.MinimalTree;

public class CheckBalanced {
    // get height of left subtree
    // if left height < 0
    //   return -1
    // get height of right subtree
    // if right height < 0
    //   return -1
    // if difference in height > 1
    //   return -1
    // return max(hLeft, hRight) + 1
    private int process(BinaryNode n) {
        if (n == null) return 0;
        int hLeft = process(n.left);
        if (hLeft < 0) return -1;
        int hRight = process(n.right);
        if (hRight < 0) return -1;
        if (Math.abs(hLeft - hRight) > 1) return -1;
        return Math.max(hLeft, hRight) + 1;
    }

    private boolean isBalanced(BinaryNode n) {
        return process(n) > 0;
    }

    private void doStart(BinaryNode head) {
        System.out.println("Balanced: " + isBalanced(head));
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

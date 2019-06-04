package ru.pasharik.chapter_4_trees_graphs.question_4_5;

import ru.pasharik.chapter_4_trees_graphs.question_4_1.BinaryNode;
import ru.pasharik.chapter_4_trees_graphs.question_4_1.GraphUtils;
import ru.pasharik.chapter_4_trees_graphs.question_4_2.MinimalTree;

public class ValidateBST2 {

    private boolean validate(BinaryNode n, int min, int max) {
        if (n == null) return true;
        if (!validate(n.left, min, n.value)) return false;
        if (!validate(n.right, n.value, max)) return false;
        return min < n.value && n.value <= max;
    }

    private boolean isValid(BinaryNode head) {
        return validate(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 2, 4, 5, 7, 8, 9, 13, 19};
        BinaryNode head = MinimalTree.create(arr);
        boolean valid = new ValidateBST2().isValid(head);

        //Printing...
        GraphUtils.printBinaryTree(head);
        System.out.println();
        System.out.println("Is valid: " + valid);
        System.out.println();

        //Invalidating
        BinaryNode b = head;
        while (b.left != null) { b = b.left; }
        b.left = new BinaryNode();
        b = b.left;
        b.left = new BinaryNode();
        b.left.value = 1;
        valid = new ValidateBST2().isValid(head);

        GraphUtils.printBinaryTree(head);
        System.out.println();
        System.out.println("Is valid: " + valid);
    }
}

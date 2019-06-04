package ru.pasharik.chapter_4_trees_graphs.question_4_5;

import ru.pasharik.chapter_4_trees_graphs.question_4_1.BinaryNode;
import ru.pasharik.chapter_4_trees_graphs.question_4_1.GraphUtils;
import ru.pasharik.chapter_4_trees_graphs.question_4_2.MinimalTree;

import java.util.concurrent.atomic.AtomicBoolean;

public class ValidateBST {

    // get left range
    // if left range == null
    //   min = value
    // else
    //   if leftRange[1] > value    isValid.set(false)
    //   min = leftRange[0]
    // get right range
    // if right range == null
    //   max = value
    // else
    //   if rightRange[0] >= value   isValid.set(false)
    //   max = rightRange[1]
    // return [min, max]
    private int[] validate(BinaryNode n, AtomicBoolean isValid) {
        if (n == null || !isValid.get()) return null;
        //Left range
        int[] leftRange = validate(n.left, isValid);
        int min, max;
        if (leftRange == null) {
            min = n.value;
        } else {
            if (leftRange[1] > n.value) isValid.set(false);
            min = leftRange[0];
        }
        //Right range
        int[] rightRange = validate(n.right, isValid);
        if (rightRange == null) {
            max = n.value;
        } else {
            if (rightRange[0] <= n.value) isValid.set(false);
            max = rightRange[1];
        }

        return new int[]{min, max};
    }

    private boolean isValid(BinaryNode head) {
        AtomicBoolean isValid = new AtomicBoolean(true);
        validate(head, isValid);
        return isValid.get();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 2, 4, 5, 7, 8, 9, 13, 19};
        BinaryNode head = MinimalTree.create(arr);
        System.out.println("Is valid: " + new ValidateBST().isValid(head));

        //Invalidating
        BinaryNode b = head;
        while (b.left != null) { b = b.left; }
        b.left = new BinaryNode();
        b = b.left;
        b.left = new BinaryNode();
        //b.left.value = 1;
        GraphUtils.printBinaryTree(head);
        System.out.println();
        System.out.println("Is valid: " + new ValidateBST().isValid(head));
    }
}

package ru.pasharik.chapter_2_linked_lists.question_2_2;

import ru.pasharik.chapter_2_linked_lists.question_2_1.LinkedListUtils;
import ru.pasharik.chapter_2_linked_lists.question_2_1.Node;

public class FindFromTheEndRecursion {
    private Node head = new Node();

    private Integer findRecursive(Node node, int targetLevel, IndexWrapper ind) {
        if (node == null) {
            return null;
        }
        Integer res = findRecursive(node.next, targetLevel, ind);
        ind.index = ind.index + 1;

        if (ind.index == targetLevel) {
            return node.value;
        } else {
            return res;
        }
    }

    private class IndexWrapper {
        public int index = 0;
    }

    private int doFind(int k) {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6};
        LinkedListUtils.fillLinkedList(arr, head);
        LinkedListUtils.printLinkedList(head);
        return findRecursive(head, k, new IndexWrapper());
    }

    public static void main(String[] args) {
        int k = 2;
        System.out.println(k + "th element from the end: " +
                new FindFromTheEndRecursion().doFind(k));
    }
}

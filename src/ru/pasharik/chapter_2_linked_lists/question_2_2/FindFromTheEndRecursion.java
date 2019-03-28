package ru.pasharik.chapter_2_linked_lists.question_2_2;

import ru.pasharik.chapter_2_linked_lists.question_2_1.LinkedListUtils;
import ru.pasharik.chapter_2_linked_lists.question_2_1.Node;

public class FindFromTheEndRecursion {
    private Node head = new Node();

    private int[] findRecursive(Node node, int targetLevel) {
        if (node.next == null) {
            return new int[]{node.value, 1};
        } else {
            int[] res = findRecursive(node.next, targetLevel);
            return (res[1] <= targetLevel) ?
                    new int[]{node.value, res[1] + 1} :
                    new int[]{res[0], res[1] + 1};
        }
    }

    private int doFind(int k) {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6};
        LinkedListUtils.fillLinkedList(arr, head);
        LinkedListUtils.printLinkedList(head);
        return findRecursive(head, k)[0];
    }

    public static void main(String[] args) {
        int k = 2;
        System.out.println(k + "th element from the end: " +
                new FindFromTheEndRecursion().doFind(k));
    }
}

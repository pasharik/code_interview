package ru.pasharik.chapter_2_linked_lists.question_2_2;

import ru.pasharik.chapter_2_linked_lists.question_2_1.LinkedListUtils;
import ru.pasharik.chapter_2_linked_lists.question_2_1.Node;

public class FindFromTheEndIteration {
    private Node head = new Node();

    private int getFromTheEnd(Node head, int k) {
        Node n = head;
        Node n1 = head;
        int i = 0;
        while (n.next != null) {
            n = n.next;
            if (i++ >= k) {
                n1 = n1.next;
            }
        }
        return n1.value;
    }

    private int doFind(int k) {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6};
        LinkedListUtils.fillLinkedList(arr, head);
        LinkedListUtils.printLinkedList(head);
        return getFromTheEnd(head, k);
    }

    public static void main(String[] args) {
        int k = 2;
        System.out.println(k + "th element from the end: " +
                new FindFromTheEndIteration().doFind(k));
    }
}

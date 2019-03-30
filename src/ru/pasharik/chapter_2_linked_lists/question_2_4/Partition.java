package ru.pasharik.chapter_2_linked_lists.question_2_4;

import ru.pasharik.chapter_2_linked_lists.question_2_1.LinkedListUtils;
import ru.pasharik.chapter_2_linked_lists.question_2_1.Node;

public class Partition {
    Node head = new Node();

    private Node doPartition(Node n, int val) {
        Node top = n;
        Node tail = n;
        while (n != null) {
            Node next = n.next;
            if (n.value < val) { //Move to the top
                n.next = top;
                top = n;
            } else { //Move to the tail
                //if (tail != n) {   // Don't really need this check, but
                    tail.next = n;   // for first element we'll get
                    tail = n;        // n.next = n  i.e. loop
                //}
            }
            n = next;
        }
        tail.next = null;
        return top;
    }

    private void doStart() {
        int[] arr = new int[]{3, 5, 8, 5, 10, 2, 1};
        LinkedListUtils.fillLinkedList(arr, head);
        LinkedListUtils.printLinkedList(head);
        System.out.println("Partitioning on 5...");
        head = doPartition(head, 5);
        LinkedListUtils.printLinkedList(head);
    }

    public static void main(String[] args) {
        new Partition().doStart();
    }
}

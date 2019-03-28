package ru.pasharik.chapter_2_linked_lists.question_2_1;

import java.util.HashSet;
import java.util.Set;

public class RemoveDupsWithBuffer {
    private Node head = new Node();
    private Set<Integer> buf = new HashSet<>();

    private void checkDups(Node head) {
        Node previous = head;
        Node n = previous.next;
        while (n != null) {
            buf.add(previous.value);
            if (buf.contains(n.value)) {
                previous.next = n.next;
            } else {
                previous = n;
            }
            n = n.next;
        }
    }

    private void doRemove() {
        int[] arr = new int[]{0, 1, 2, 3, 0, 2, 0};
        //int[] arr = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        LinkedListUtils.fillLinkedList(arr, head);
        LinkedListUtils.printLinkedList(head);
        checkDups(head);
        System.out.println("Removing duplicates...");
        LinkedListUtils.printLinkedList(head);
    }

    public static void main(String[] args) { new RemoveDupsWithBuffer().doRemove(); }
}

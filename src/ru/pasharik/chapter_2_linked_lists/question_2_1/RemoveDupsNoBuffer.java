package ru.pasharik.chapter_2_linked_lists.question_2_1;

public class RemoveDupsNoBuffer {
    private Node head = new Node();

    private void checkDupsNoBuffer(Node head) {
        Node n = head;
        while (n != null) {
            removeFromList(n, n.value);
            n = n.next;
        }
    }

    private void removeFromList(Node head, int val) {
        Node previous = head;
        Node n = previous.next;
        while (n != null) {
            if (val == n.value) {
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
        checkDupsNoBuffer(head);
        System.out.println("Removing duplicates...");
        LinkedListUtils.printLinkedList(head);
    }

    public static void main(String[] args) { new RemoveDupsNoBuffer().doRemove(); }
}

package ru.pasharik.chapter_2_linked_lists.question_2_3;

import ru.pasharik.chapter_2_linked_lists.question_2_1.LinkedListUtils;
import ru.pasharik.chapter_2_linked_lists.question_2_1.Node;

public class DeleteMiddleNode {
    private Node head = new Node();

    private void doDelete(Node n) {
        n.value = n.next.value;
        n.next = n.next.next;
    }

    private void doStart() {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6};
        LinkedListUtils.fillLinkedList(arr, head);
        LinkedListUtils.printLinkedList(head);
        Node n = getNodeFromList(head, 2);
        System.out.println("Deleting node: " + n.value);
        doDelete(n);
        LinkedListUtils.printLinkedList(head);
    }

    private Node getNodeFromList(Node node, int index) {
        int i = 0;
        while (node != null) {
            if (i++ == index) return node;
            node = node.next;
        }
        return null;
    }

    public static void main(String[] args) {
        new DeleteMiddleNode().doStart();
    }
}

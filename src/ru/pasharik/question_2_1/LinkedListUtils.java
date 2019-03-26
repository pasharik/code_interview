package ru.pasharik.question_2_1;

public class LinkedListUtils {
    public static void fillLinkedList(int[] a, Node head) {
        Node n = head;
        for (int i = 0; i < a.length; i++) {
            n.value = a[i];
            if (i < a.length - 1) {
                n.next = new Node();
                n = n.next;
            }
        }
    }

    public static void printLinkedList(Node n) {
        while (n != null) {
            System.out.print(n.value + " ");
            n = n.next;
        }
        System.out.println();
    }
}

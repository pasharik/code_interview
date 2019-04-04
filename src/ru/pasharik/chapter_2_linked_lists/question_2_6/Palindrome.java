package ru.pasharik.chapter_2_linked_lists.question_2_6;

import ru.pasharik.chapter_2_linked_lists.question_2_1.LinkedListUtils;
import ru.pasharik.chapter_2_linked_lists.question_2_1.Node;

/* This algorithm modifies the original list.
   It can be not desired in some cases */
public class Palindrome {
    private Node head = new Node();

    private int getLength(Node n) {
        int i = 0;
        while (n != null) {
            n = n.next;
            i++;
        }
        return i;
    }

    private boolean compareLists(Node n1, Node n2) {
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) return false;
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1 == null && n2 == null;
    }

    private boolean doReverse(Node n, int len) {
        int middleIndex = len / 2;
        int i = 0;
        // Reverse first half of linked list
        Node tail = null;
        while (++i <= middleIndex) {
            Node next = n.next;
            n.next = tail;
            tail = n;
            n = next;
        }

        System.out.println("Tail: " + tail.value);
        if (len % 2 == 1) { n = n.next; } //Odd length

        //Compare with second half
        System.out.println("Next: " + n.value);
        return compareLists(tail, n);
    }

    private void doStart() {
        int[] arr = new int[]{0, 1, 2, 3, 2, 1, 0};
//        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
//        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6};
        LinkedListUtils.fillLinkedList(arr, head);
        LinkedListUtils.printLinkedList(head);
        System.out.println(doReverse(head, getLength(head)));
        //System.out.println("Length: " + getLength(head));
    }

    public static void main(String[] args) {
        new Palindrome().doStart();
    }
}

package ru.pasharik.chapter_2_linked_lists.question_2_8;

import ru.pasharik.chapter_2_linked_lists.question_2_1.LinkedListUtils;
import ru.pasharik.chapter_2_linked_lists.question_2_1.Node;

public class Loop {
    private Node head = new Node();

    private Node doOffset(Node n, int offset) {
        while (offset-- > 0) n = n.next;
        return n;
    }

    private Node findIntersection(Node n1, Node n2) {
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    private Node getNodeInLoop(Node n) {
        if (n == null || n.next == null) return null;
        Node slow = n;
        Node fast = n;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return slow;
        }
        return null;
    }

    private int lengthBetweenNodes(Node n, Node tail) {
        int i = 0;
        do {
            n = n.next;
            i++;
        } while (n != tail);
        return i;
    }

    /* n1 - head of list
       n2 - node on a loop */
    private Node findLoopBeginning(Node n1, Node n2) {
        int len1 = lengthBetweenNodes(n1, n2);
        int len2 = lengthBetweenNodes(n2, n2);
        if (len1 > len2) {
            Node n = doOffset(n1, len1 - len2);
            return findIntersection(n, n2);
        } else {
            Node n = doOffset(n2, len2 - len1);
            return findIntersection(n, n1);
        }
    }

    private void doStart() {
        setup();
        Node nodeInLoop = getNodeInLoop(head);
        if (nodeInLoop != null) {
            System.out.println("Loop beginning: " + findLoopBeginning(head, nodeInLoop).value);
        } else {
            System.out.println("No loop");
        }
    }

    private void setup() {
        int[] arr = new int[]{0, 1, 2, 3, 4};
        //                          2 - start of the loooooop
        LinkedListUtils.fillLinkedList(arr, head);
        createLoop(head, 2);
    }

    private void createLoop(Node n, int value) {
        if (n == null || n.next == null) return;
        Node loopStart = n;
        while (n.next != null) {
            if (n.value == value) loopStart = n;
            n = n.next;
        }
        n.next = loopStart;
    }

    public static void main(String[] args) {
        new Loop().doStart();
    }
}

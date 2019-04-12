package ru.pasharik.chapter_2_linked_lists.question_2_7;

import ru.pasharik.chapter_2_linked_lists.question_2_1.LinkedListUtils;
import ru.pasharik.chapter_2_linked_lists.question_2_1.Node;

public class Intersection {
    private Node head1 = new Node();
    private Node head2 = new Node();
    private Node head3 = new Node();

    private Result getTail(Node n) {
        int len = 0;
        while (n != null && n.next != null) {
            n = n.next;
            len++;
        }
        Result result = new Result();
        result.tail = n;
        result.len = len;
        return result;
    }

    private Node doOffset(Node n, int offset) {
        while (offset-- > 0) n = n.next;
        return n;
    }

    private Node getIntersection(Node n1, Node n2, int len1, int len2) {
        if (len1 > len2) {
            n1 = doOffset(n1, len1 - len2);
        } else if (len2 > len1) {
            n2 = doOffset(n2, len2 - len1);
        }
        LinkedListUtils.printLinkedList(n1);
        LinkedListUtils.printLinkedList(n2);

        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    private Node doStart() {
        setup();
        Result res1 = getTail(head1);
        Result res2 = getTail(head2);
        int len1 = res1.len;
        int len2 = res2.len;
        if (res1.tail != res2.tail) return null;
        System.out.println("Lenght1: " + len1 + "; Length2: " + len2);
        System.out.println("Normilizing length:");
        return getIntersection(head1, head2, len1, len2);
    }

    private void setup() {
        int[] arr1 = new int[]{   1, 2            };
        int[] arr2 = new int[]{9, 8, 7            };
        int[] arr3 = new int[]{         3, 2, 1, 0};
        LinkedListUtils.fillLinkedList(arr1, head1);
        LinkedListUtils.fillLinkedList(arr2, head2);
        LinkedListUtils.fillLinkedList(arr3, head3);
        getTail(head1).tail.next = head3;
        getTail(head2).tail.next = head3;
        LinkedListUtils.printLinkedList(head1);
        LinkedListUtils.printLinkedList(head2);
    }

    private class Result {
        Node tail;
        int len;
    }

    public static void main(String[] args) {
        Node n = new Intersection().doStart();
        System.out.println(n != null ? "Intersection: " + n.value : "Not intersecting");
    }
}

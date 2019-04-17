package ru.pasharik.chapter_3_stacks_queues.question_3_2;

import ru.pasharik.chapter_2_linked_lists.question_2_1.LinkedListUtils;
import ru.pasharik.chapter_2_linked_lists.question_2_1.Node;

public class MinLinkedStack {
    private Node top = null;
    private Node minTop = null;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int value) {
        Node n = new Node();
        n.value = value;
        n.next = top;
        top = n;
        //Min
        if (minTop == null || value <= minTop.value) {
            Node nMin = new Node();
            nMin.value = value;
            nMin.next = minTop;
            minTop = nMin;
        }
    }

    public int peek() {
        if (top == null) throw new NullPointerException("Stack is empty!");
        return top.value;
    }

    public int pop() {
        if (top == null) throw new NullPointerException("Stack is empty!");
        Node n = top;
        top = top.next;

        if (n.value == minTop.value) {
            minTop = minTop.next;
        }
        return n.value;
    }

    public int min() {
        if (top == null) throw new NullPointerException("Stack is empty!");
        return minTop.value;
    }

    public static void main(String[] args) {
        MinLinkedStack s = new MinLinkedStack();
        int[] arr = new int[]{0, 1, 2, 3, 0, 4, 5, 6, -1, 2, 8};
        for (int i : arr) s.push(i);
        System.out.print("Min stack: ");
        LinkedListUtils.printLinkedList(s.minTop);
        System.out.println();
        while (!s.isEmpty()) System.out.println("Min: " + s.min() + "\t value: " + s.pop());
    }
}

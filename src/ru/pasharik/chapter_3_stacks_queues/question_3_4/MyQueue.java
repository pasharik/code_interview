package ru.pasharik.chapter_3_stacks_queues.question_3_4;

import ru.pasharik.chapter_2_linked_lists.question_2_1.Node;

public class MyQueue {
    private Node top = null;
    private Node tail = null;

    public void add(int value) {
        Node n = new Node();
        n.value = value;
        if (isEmpty()) {
            top = n;
            tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    public int remove() {
        if (isEmpty()) throw new NullPointerException("Queue is empty!");
        int value = top.value;
        top = top.next;
        if (top == null) {
            tail = null;
        }
        return value;
    }

    public int peek() {
        if (isEmpty()) throw new NullPointerException("Queue is empty!");
        return top.value;
    }

    private boolean isEmpty() {
        return top == null && tail == null;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6};
        MyQueue q = new MyQueue();
        for (int i : arr) q.add(i);
        while (!q.isEmpty()) System.out.println(q.remove());
    }
}

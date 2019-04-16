package ru.pasharik.chapter_3_stacks_queues.question_3_1;

import ru.pasharik.chapter_2_linked_lists.question_2_1.Node;

public class MyLinkedStack {
    private Node top = null;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int value) {
        Node n = new Node();
        n.value = value;
        n.next = top;
        top = n;
    }

    public int peek() {
        if (top == null) throw new NullPointerException("Stack is empty!");
        return top.value;
    }

    public int pop() {
        if (top == null) throw new NullPointerException("Stack is empty!");
        Node n = top;
        top = top.next;
        return n.value;
    }

    public static void main(String[] args) {
        MyLinkedStack s = new MyLinkedStack();
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6};
        for (int i : arr) s.push(i);
        while (!s.isEmpty()) System.out.println(s.pop());
    }
}

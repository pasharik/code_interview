package ru.pasharik.chapter_3_stacks_queues.question_3_5;

import ru.pasharik.chapter_3_stacks_queues.question_3_1.MyLinkedStack;

public class InsertionSortStack {
    private MyLinkedStack s1 = new MyLinkedStack();
    private MyLinkedStack s2 = new MyLinkedStack(); //Sorted elements

    private void doSort() {
        while (!s1.isEmpty()) {
            int val = s1.pop();
            while (!s2.isEmpty() && s2.peek() > val) {
                s1.push(s2.pop());
            }
            s2.push(val);
            while (!s1.isEmpty() && s1.peek() > s2.peek()) {
                s2.push(s1.pop());
            }
        }
        while (!s2.isEmpty()) s1.push(s2.pop());
    }

    private void doStart() {
        int[] arr = new int[]{2, 1, 4, 0, 3, 6, 5};
        for (int i : arr) s1.push(i);
        doSort();
        System.out.println("Sorted:");
        while (!s1.isEmpty()) System.out.println(s1.pop());

        // s2 - sorted elements
        // while s1 not empty
        //   val = pop from s1
        //   while s2 is NOT empty AND s2.peek > val
        //     s1.push(s2.pop)
        //   s2.push(val)
        //   while ((both not empty) && s1.peek > s2.peek)
        //     s2.push(s1.pop)
        //
        // move everything from s2 to s1
    }

    public static void main(String[] args) {
        new InsertionSortStack().doStart();
    }
}

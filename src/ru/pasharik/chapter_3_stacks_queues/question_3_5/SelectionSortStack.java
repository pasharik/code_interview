package ru.pasharik.chapter_3_stacks_queues.question_3_5;

import ru.pasharik.chapter_3_stacks_queues.question_3_1.MyLinkedStack;

public class SelectionSortStack {
    MyLinkedStack s1 = new MyLinkedStack();
    MyLinkedStack s2 = new MyLinkedStack();

    private int getSize() {
        int size = 0;
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
            size++;
        }
        while (!s2.isEmpty()) s1.push(s2.pop());
        return size;
    }

    private int findMin() {
        Integer min = null;
        while (!s1.isEmpty()) {
            int val = s1.pop();
            if (min == null || val < min) {
                min = val;
            }
            s2.push(val);
        }
        return min;
    }

    private void moveBackSkipMin(int size, int currentIndex, int min) {
        boolean skipped = false;
        for (int j = size - currentIndex; j > 0; j--) {
            int val = s2.pop();
            if (val != min || skipped) {
                s1.push(val);
            } else {
                skipped = true; //In case there are multiple elements equal to min
            }
        }
    }

    private void doSort() {
        int size = getSize();
        for (int i = 0; i < size; i++) {
            int min = findMin();
            moveBackSkipMin(size, i, min);
            s2.push(min);
        }
        while (!s2.isEmpty()) s1.push(s2.pop());
    }

    private void doStart() {
        int[] arr = new int[]{2, 1, 4, 0, 3, 6, 5};
        for (int i : arr) s1.push(i);
        doSort();
        System.out.println("Sorted:");
        while (!s1.isEmpty()) System.out.println(s1.pop());

        //get size
        //for i = 0 to size
        //  move elements to s2
        //    remember smallest
        //  move (size-i) elements back to s1
        //    if element == smallest, do NOT push it back to s1
        //  push smallest to s2
        //  i++
        //
        //move everything from s2 to s1
    }
    public static void main(String[] args) {
        new SelectionSortStack().doStart();
    }
}

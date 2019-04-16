package ru.pasharik.chapter_3_stacks_queues.question_3_1;

public class ArrayStack {
    private int[] a = new int[2];
    int idx = 0;

    public boolean isEmpty() {
        return idx == 0;
    }

    public void push(int i) {
        a[idx++] = i;
        checkResize();
    }

    public int peek() {
        if (isEmpty()) throw new NullPointerException("Stack is empty!");
        return a[idx - 1];
    }

    public int pop() {
        if (isEmpty()) throw new NullPointerException("Stack is empty!");
        checkResize();
        return a[--idx];
    }

    private void checkResize() {
        if (idx == a.length) {
            System.out.println("Increasing size");
            int[] a2 = new int[a.length * 2];
            System.arraycopy(a, 0, a2, 0, a.length);
            a = a2;
        } else if (idx == a.length / 4) {
            System.out.println("Decreasing");
            int[] a2 = new int[a.length / 2];
            System.arraycopy(a, 0, a2, 0, a2.length);
            a = a2;
        }
    }

    public static void main(String[] args) {
        ArrayStack s = new ArrayStack();
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        for (int i : arr) s.push(i);
        while (!s.isEmpty()) System.out.println(s.pop());
    }
}

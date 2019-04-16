package ru.pasharik.chapter_3_stacks_queues.question_3_1;

public class ArrayThreeStacks {
    private int[] a = new int[40];
    private static int NUM_OF_STACKS = 3;

    private class SubStack {
        private int num;
        private int idx;
        public SubStack(int num) {
            this.num = num;
            this.idx = num;
        }

        public boolean isEmpty() {
            return idx == num;
        }

        public void push(int i) {
            a[idx] = i;
            idx += NUM_OF_STACKS;
        }

        public int peek() {
            if (isEmpty()) throw new NullPointerException("Stack is empty!");
            return a[idx - NUM_OF_STACKS];
        }

        public int pop() {
            if (isEmpty()) throw new NullPointerException("Stack is empty!");
            idx -= NUM_OF_STACKS;
            return a[idx];
        }
    }

    private void doStart() {
        SubStack s0 = new SubStack(0);
        SubStack s1 = new SubStack(1);
        SubStack s2 = new SubStack(2);
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        for (int i : arr) {
            s0.push(i);
            s1.push(i);
            s2.push(i);
        }
        while (!s0.isEmpty()) System.out.println(s0.pop() + "  -  " + s1.pop() + "  -  " + s2.pop());
    }

    public static void main(String[] args) { new ArrayThreeStacks().doStart(); }
}

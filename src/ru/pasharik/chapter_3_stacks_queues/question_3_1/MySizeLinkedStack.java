package ru.pasharik.chapter_3_stacks_queues.question_3_1;

public class MySizeLinkedStack extends MyLinkedStack {
    private int size = 0;
    @Override
    public void push(int value) {
        super.push(value);
        size++;
    }

    @Override
    public int pop() {
        int res = super.pop();
        size--;
        return res;
    }

    public int size() {
        return size;
    }
}

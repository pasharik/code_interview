package ru.pasharik.chapter_3_stacks_queues.question_3_3;

import ru.pasharik.chapter_3_stacks_queues.question_3_1.MyLinkedStack;
import ru.pasharik.chapter_3_stacks_queues.question_3_1.MySizeLinkedStack;

import java.util.ArrayList;
import java.util.List;

public class StackOfPlates {
    List<MySizeLinkedStack> list = new ArrayList<>();
    private static int MAX_SIZE = 3;

    public void push(int value) {
        if (list.isEmpty() || lastStack().size() >= MAX_SIZE) {
            list.add(new MySizeLinkedStack());
        }
        lastStack().push(value);
    }

    public boolean isEmpty() {
        return list.isEmpty() || lastStack().isEmpty();
    }

    public int peek() {
        if (isEmpty()) throw new NullPointerException("Stack is empty!");
        return lastStack().peek();
    }

    public int pop() {
        if (isEmpty()) throw new NullPointerException("Stack is empty!");
        MySizeLinkedStack s = lastStack();
        int value = s.pop();
        if (s.isEmpty()) {
            list.remove(list.size() - 1);
        }
        return value;
    }

    public int popAt(int index) {
        if (isEmpty()) throw new NullPointerException("Stack is empty!");
        if (index < 0 || index >= list.size()) throw new IllegalArgumentException("Wrongn index");
        MySizeLinkedStack s = list.get(index);
        int value = s.pop();
        if (s.isEmpty()) {
            list.remove(index);
        }
        return value;
    }

    private MySizeLinkedStack lastStack() {
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        StackOfPlates s = new StackOfPlates();
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6};
        for (int i : arr) s.push(i);
        while (!s.isEmpty()) System.out.println("Num of stacks: " + s.list.size() + " ; " + s.pop());
        System.out.println("------ Pop AT index -----");
        arr = new int[]{0, 1, 2, 3, 4, 5, 6};
        for (int i : arr) s.push(i);
        while (!s.isEmpty()) System.out.println("Num of stacks: " + s.list.size() + " ; " + s.popAt(0));
    }
}

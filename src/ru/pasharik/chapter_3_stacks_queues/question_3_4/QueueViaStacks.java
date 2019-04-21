package ru.pasharik.chapter_3_stacks_queues.question_3_4;

import ru.pasharik.chapter_3_stacks_queues.question_3_1.MyLinkedStack;
import ru.pasharik.chapter_3_stacks_queues.question_3_1.MySizeLinkedStack;

public class QueueViaStacks {
    private MySizeLinkedStack s1 = new MySizeLinkedStack();
    private MySizeLinkedStack s2 = new MySizeLinkedStack();

    public void add(int value) {
        s1.push(value);
    }

    public int remove() {
        checkCopy();
        return s2.pop();
    }

    public int peek() {
        checkCopy();
        return s2.peek();
    }

    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public int size() {
        return s1.size() + s2.size();
    }

    private void checkCopy() {
        if (isEmpty()) throw new NullPointerException("Q is empty!");
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) s2.push(s1.pop());
        }
    }

    public static void main(String[] args) {
        QueueViaStacks q = new QueueViaStacks();
        q.add(0);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println("Removing...");
        System.out.println(q.remove() + " ; Q size: " + q.size());
        System.out.println(q.remove() + " ; Q size: " + q.size());
        System.out.println("Adding again...");
        q.add(5);
        q.add(6);
        while (!q.isEmpty()) System.out.println(q.remove() + " ; Q size: " + q.size());
    }
}

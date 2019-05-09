package ru.pasharik.chapter_4_trees_graphs.question_4_3;

import ru.pasharik.chapter_4_trees_graphs.question_4_1.BinaryNode;
import ru.pasharik.chapter_4_trees_graphs.question_4_2.MinimalTree;

import java.util.ArrayList;
import java.util.List;

public class ListOfDepths {
    List<List<BinaryNode>> list = new ArrayList<>();

    private void processLayer(BinaryNode n, int level) {
        if (n == null) return;
        if (list.size() <= level) {
            list.add(level, new ArrayList<>());
        }
        list.get(level).add(n);
        processLayer(n.left, level + 1);
        processLayer(n.right, level + 1);
    }

    private void doStart(BinaryNode n) {
        processLayer(n, 0);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 2, 4, 5, 7, 8, 9, 13, 19};
        BinaryNode head = MinimalTree.create(arr);
        ListOfDepths ll = new ListOfDepths();
        ll.doStart(head);
        ll.list.forEach(System.out::println);
    }
}

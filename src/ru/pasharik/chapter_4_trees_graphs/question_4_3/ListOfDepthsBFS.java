package ru.pasharik.chapter_4_trees_graphs.question_4_3;

import ru.pasharik.chapter_4_trees_graphs.question_4_1.BinaryNode;
import ru.pasharik.chapter_4_trees_graphs.question_4_2.MinimalTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListOfDepthsBFS {
    List<List<BinaryNode>> list = new ArrayList<>();

    private static class QWrapper {
        public BinaryNode node;
        public int level;
    }

    // take from the Q
    // get level
    // add to list for corresponding level
    // for each child
    //   create wrapper with level + 1
    //   wrapper.node = child
    //   store wrapper on Q
    private void doStart(BinaryNode n) {
        Queue<QWrapper> q = new LinkedList<>();
        QWrapper w = new QWrapper();
        w.node = n;
        w.level = 0;
        q.add(w);
        while (!q.isEmpty()) {
            QWrapper ww = q.remove();
            int level = ww.level;
            if (list.size() <= level) {
                list.add(level, new LinkedList<>());
            }
            list.get(level).add(ww.node);
            addChildToQ(ww.node.left, q, level);
            addChildToQ(ww.node.right, q, level);
        }
    }

    private void addChildToQ(BinaryNode n, Queue<QWrapper> q, int level) {
        if (n == null) return;
        QWrapper w = new QWrapper();
        w.node = n;
        w.level = level + 1;
        q.add(w);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 2, 4, 5, 7, 8, 9, 13, 19, 22};
        BinaryNode head = MinimalTree.create(arr);
        ListOfDepthsBFS ll = new ListOfDepthsBFS();
        ll.doStart(head);
        ll.list.forEach(System.out::println);
    }
}

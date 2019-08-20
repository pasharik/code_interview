package ru.pasharik.chapter_4_trees_graphs.question_4_6;

import ru.pasharik.chapter_4_trees_graphs.question_4_1.BinaryNode;
import ru.pasharik.chapter_4_trees_graphs.question_4_1.GraphUtils;
import ru.pasharik.chapter_4_trees_graphs.question_4_2.MinimalTree;

/*
1. Has right:
   * go right
   * go left untill left != null
2. Has no right

find 'root' parent, where current node is left - recursion
if no such parent, return null */

public class Successor {
    private BinaryNode findSuccessor(BinaryNodeParent head) {
        if (head == null) return null;
        if (head.right != null) {
            return findLeftMost(head.right);
        }
        return findRootParent(head);
    }

    private BinaryNode findRootParent(BinaryNodeParent n) {
        if (n == null || n.parent == null) return null;
        BinaryNodeParent p = (BinaryNodeParent) n.parent;
        if (p.left == n) return p;
        return findRootParent(p);
    }

    private BinaryNode findLeftMost(BinaryNode n) {
        if (n == null || n.left == null) return n;
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 2, 4, 5, 7, 8, 9, 13, 19};
        BinaryNodeParent head = (BinaryNodeParent) MinimalTree.create(arr);
        System.out.println(new Successor().findSuccessor(head));
    }
}

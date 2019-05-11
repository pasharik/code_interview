package ru.pasharik.chapter_4_trees_graphs.question_4_3;

import ru.pasharik.chapter_4_trees_graphs.question_4_1.BinaryNode;
import ru.pasharik.chapter_4_trees_graphs.question_4_2.MinimalTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListOfDepthsBFS2 {
    List<List<BinaryNode>> result = new ArrayList<>();

    //add head to currentChild list
    //while currentChild is not empty
    //  newChild = new List
    //  for each node in currentChild
    //    add left & right into newChild
    //  add currentChild into result
    //  currentChild = newChild
    private void doStart(BinaryNode n) {
        List<BinaryNode> currentChildren = new LinkedList<>();
        currentChildren.add(n);
        while (!currentChildren.isEmpty()) {
            List<BinaryNode> newChildren = new LinkedList<>();
            for (BinaryNode node : currentChildren) {
                if (node.left != null) newChildren.add(node.left);
                if (node.right != null) newChildren.add(node.right);
            }
            result.add(currentChildren);
            currentChildren = newChildren;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 2, 4, 5, 7, 8, 9, 13, 19, 22};
        BinaryNode head = MinimalTree.create(arr);
        ListOfDepthsBFS2 ll = new ListOfDepthsBFS2();
        ll.doStart(head);
        ll.result.forEach(System.out::println);
    }
}

package ru.pasharik.chapter_4_trees_graphs.question_4_1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RouteBetweenNodes {
    private static final int[][] ADJACENCY_LIST = new int[][] {
            {1},    //0
            {2, 7}, //1
            {3},    //2
            {4, 7}, //3
            {5, 3}, //4
            {6},    //5
            {},     //6
            {}      //7
    };

    // add root to Q
    // while Q is not empty
    //   remove node from Q
    //   check if node connected
    //     if yes, return true
    //     if no, add all children to Q
    //
    // return false
    private boolean isConnected(TreeNode root, TreeNode target) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        root.visited = true;
        while (!q.isEmpty()) {
            TreeNode n = q.remove();
            if (n == target) return true;
            for (TreeNode child : n.children) {
                if (!child.visited) {
                    q.add(child);
                    child.visited = true;
                }
            }
        }
        return false;
    }

    private void doStart(int index1, int index2) {
        MyGraph g = new MyGraph(ADJACENCY_LIST);
        g.printGraph();
        System.out.println(index1 + " and " + index2 + " connected: " +
                isConnected(g.nodes[index1], g.nodes[index2]));
    }

    public static void main(String[] args) {
        new RouteBetweenNodes().doStart(4, 0);
        new RouteBetweenNodes().doStart(0, 4);
    }
}

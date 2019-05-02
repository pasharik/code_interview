package ru.pasharik.chapter_4_trees_graphs.question_4_1;

public class RouteBetweenNodes {
    private static final int[][] ADJACENCY_LIST = new int[][] {
            {1},    //0
            {2, 7}, //1
            {3},    //2
            {4, 7}, //3
            {5},    //4
            {6},    //5
            {},     //6
            {}      //7
    };

    private class Graph {
        TreeNode[] nodes;
    }

    private void doStart() {
        Graph g = init(ADJACENCY_LIST);
        printGraph(g);
    }

    private void printGraph(Graph graph) {
        for (TreeNode n : graph.nodes) {
            System.out.print(n.value + " : ");
            for (TreeNode child : n.children) {
                System.out.print(child.value + " ");
            }
            System.out.println();
        }
    }

    private Graph init(int[][] adjacencyList) {
        Graph g = new Graph();
        g.nodes = new TreeNode[adjacencyList.length];
        for (int i = 0; i < adjacencyList.length; i++) {
            TreeNode node = new TreeNode();
            node.name = "Node_" + i;
            node.value = i;
            g.nodes[i] = node;
        }
        for (int i = 0; i < adjacencyList.length; i++) {
            int[] arr = adjacencyList[i];
            TreeNode node = g.nodes[i];
            node.children = new TreeNode[arr.length];
            for (int j = 0; j < arr.length; j++) {
                int childIndex = arr[j];
                //g.nodes[i].a
                node.children[j] = g.nodes[childIndex];
            }
        }
        return g;
    }

    public static void main(String[] args) {
        new RouteBetweenNodes().doStart();
        //System.out.println("Route between nodes");
    }
}

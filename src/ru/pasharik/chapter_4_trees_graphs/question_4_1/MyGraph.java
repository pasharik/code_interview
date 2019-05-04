package ru.pasharik.chapter_4_trees_graphs.question_4_1;

public class MyGraph {
    public TreeNode[] nodes;

    public MyGraph(int[][] adjacencyList) {
        nodes = new TreeNode[adjacencyList.length];
        for (int i = 0; i < adjacencyList.length; i++) {
            TreeNode node = new TreeNode();
            node.name = "Node_" + i;
            node.value = i;
            nodes[i] = node;
        }
        for (int i = 0; i < adjacencyList.length; i++) {
            int[] arr = adjacencyList[i];
            TreeNode node = nodes[i];
            node.children = new TreeNode[arr.length];
            for (int j = 0; j < arr.length; j++) {
                int childIndex = arr[j];
                node.children[j] = nodes[childIndex];
            }
        }
    }

    public void printGraph() {
        for (TreeNode n : nodes) {
            System.out.print(n.value + " : ");
            for (TreeNode child : n.children) {
                System.out.print(child.value + " ");
            }
            System.out.println();
        }
    }
}

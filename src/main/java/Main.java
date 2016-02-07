public class Main {
    public static void main(String[] args) {
        final Graph graph = new Graph();
        graph.addNode();
        graph.addNode();
        graph.addNode("a");
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        Graph.Node node1 = new Graph.Node("l1");
        Graph.Node node2 = new Graph.Node("l2");
        Graph.Node node3 = new Graph.Node("l3");
        Graph.Node node4 = new Graph.Node("l4");
        Graph.Node node5 = new Graph.Node("l5");
        Graph.Node node6 = new Graph.Node("l6");
        Graph.Node node7 = new Graph.Node("l7");
        Graph.Node node8 = new Graph.Node("l8");
        Graph.Node node9 = new Graph.Node("l9");
        graph.addNode(node1);
        graph.addNode(node2);
        graph.addNode(node3);
        graph.addNode(node4);
        graph.addNode(node5);
        graph.addNode(node6);
        graph.addNode(node7);
        graph.addNode(node8);
        graph.addNode(node9);
        graph.connect(node1, node2);
        graph.connect(node1, node3);
        graph.connect(node2, node4);
        graph.connect(node2, node5);
        graph.connect(node3, node6);
        graph.connect(node4, node7);
        graph.connect(node5, node6);
        graph.connect(node5, node8);
        graph.connect(node7, node8);


        System.out.println("Nodes with tag 'a': " + graph.getNodesByTag("a"));
        System.out.println("*********************************************");
        System.out.println("Nodes sorted by tag: " + graph.getNodesSortedByTag());
        System.out.println("*********************************************");
        System.out.println("Distance between node1 and node8 = " + graph.getDistance(node1, node8));
        System.out.println("Distance between node2 and node6 = " + graph.getDistance(node2, node6));
        System.out.println("Distance between node7 and node3 = " + graph.getDistance(node7, node3));
        System.out.println("Distance between node7 and node7 = " + graph.getDistance(node7, node7));
        System.out.println("Distance between node7 and node9 = " + graph.getDistance(node7, node9));

        graph.disconnect(node7, node8);
        graph.disconnect(node1, node2);
        System.out.println("Distance between node7 and node3 = " + graph.getDistance(node7, node3));
    }
}

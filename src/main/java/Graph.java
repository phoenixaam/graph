import java.util.*;

public class Graph {
    static class Node implements Comparable {
        private static int nextId = 0;

        private int id;
        private String tag;
        private List<Node> links;

        public Node(String tag) {
            this.tag = tag;
            id = nextId++;
        }

        public void connect(Node node) {
            Objects.requireNonNull(node);
            if (links == null) {
                links = new LinkedList<>();
            }
            links.add(node);
        }

        public void disconnect(Node node) {
            Objects.requireNonNull(node);
            links.remove(node);
        }

        public int compareTo(Object o) {
            if (this == o) return 0;
            if (o == null || !(o instanceof Node)) {
                return -1;
            }
            return tag.compareTo(((Node) o).tag);
        }

        public String getTag() {
            return tag;
        }

        public List<Node> getLinks() {
            return links;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", tag='" + tag + '\'' + "}";
        }
    }

    private Set<Node> nodes;

    public void addNode() {
        String tag = "";
        addNode(tag);
    }

    public void addNode(final String tag) {
        final Node node = new Node(tag);
        addNode(node);
    }

    public void addNode(Node node) {
        if (nodes == null) {
            nodes = new HashSet<>();
        }
        nodes.add(node);
    }


    public void connect(final Node node1, final Node node2) {
        Objects.requireNonNull(node1);
        Objects.requireNonNull(node2);
        node1.connect(node2);
        node2.connect(node1);
    }

    public void disconnect(final Node node1, final Node node2) {
        Objects.requireNonNull(node1);
        Objects.requireNonNull(node2);
        node1.disconnect(node2);
        node2.disconnect(node1);
    }

    public Set<Node> getNodesByTag(final String tag) {
        Objects.requireNonNull(tag);
        final HashSet<Node> nodesByTag = new HashSet<>();
        for (Node node : nodes) {
            if (tag.equals(node.getTag())) {
                nodesByTag.add(node);
            }
        }
        return Collections.unmodifiableSet(nodesByTag);
    }

    public List<Node> getNodesSortedByTag() {
        final LinkedList<Node> sortedNodes = new LinkedList<>();
        sortedNodes.addAll(nodes);
        Collections.sort(sortedNodes);
        return Collections.unmodifiableList(sortedNodes);
    }

    public double getDistance(final Node node1, final Node node2) {
        Objects.requireNonNull(node1);
        Objects.requireNonNull(node2);
        double distance = 0;
        final Map<Node, Double> distances = new HashMap<>();
        distances.put(node1, distance);
        getDistancesPerNodesInList(node1, distance, distances);
        if (distances.containsKey(node2)) {
            distance = distances.get(node2);
        } else {
            System.out.println("There aren't links between " + node1 + " and " + node2 + " in current graph.");
            distance = Double.POSITIVE_INFINITY;
        }
        return distance;
    }


    private void getDistancesPerNodesInList(Node node, double initialDistance, Map<Node, Double> distances) {
        final List<Node> links = node.getLinks();
        if (links != null) {
            initialDistance++;
            for (Node nodeFromLinks : links) {
                if (!distances.containsKey(nodeFromLinks) || distances.get(nodeFromLinks) >= initialDistance) {
                    distances.put(nodeFromLinks, initialDistance);
                    getDistancesPerNodesInList(nodeFromLinks, initialDistance, distances);
                }
            }
        }
    }


}

import java.util.*;

class Vertex{
    String node;
    Vertex(String node){
        this.node = node;
    }
}
public class Graph {
    private Map<Vertex, List<Vertex>> adjacency;
    void addVertex(String node){
        adjacency.putIfAbsent(new Vertex(node), new ArrayList<>());
    }
    void removeVertex(String node){
        Vertex v = new Vertex(node);
        adjacency.values().stream().forEach(e -> e.remove(v));
        adjacency.remove(new Vertex(node));
    }
    void addEdge(String nodeA, String nodeB){
        Vertex vA = new Vertex(nodeA);
        Vertex vB = new Vertex(nodeB);
        adjacency.get(vA).add(vB);
        adjacency.get(vB).add(vA);
    }
    void removeEdge(String nodeA, String nodeB){
        Vertex vA = new Vertex(nodeA);
        Vertex vB = new Vertex(nodeB);
        if(adjacency.get(vA)!= null){
            adjacency.get(vA).remove(vB);
        }
        if(adjacency.get(vB)!= null){
            adjacency.get(vB).remove(vA);
        }
    }
    List<Vertex> getAdjacent(String node){
        return adjacency.get(new Vertex(node));
    }
    Graph createGraph() {
        Graph graph = new Graph();
        graph.addVertex("Bob");
        graph.addVertex("Alice");
        graph.addVertex("Mark");
        graph.addVertex("Rob");
        graph.addVertex("Maria");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Bob", "Rob");
        graph.addEdge("Alice", "Mark");
        graph.addEdge("Rob", "Mark");
        graph.addEdge("Alice", "Maria");
        graph.addEdge("Rob", "Maria");
        return graph;
    }
    
}

import java.security.KeyStore.Entry;
import java.util.*;

class Vertex{
    String node;
    Vertex(String node){
        this.node = node;
    }
    // @Override
    // public boolean equals(Object obj) 
    // { 
          
    // // if both the object references are  
    // // referring to the same object. 
    // if(this == obj) 
    //         return true; 
          
    //     // it checks if the argument is of the  
    //     // type Geek by comparing the classes  
    //     // of the passed argument and this object. 
    //     // if(!(obj instanceof Geek)) return false; ---> avoid. 
    //     if(obj == null || obj.getClass()!= this.getClass()) 
    //         return false; 
          
    //     // type casting of the argument.  
    //     Vertex geek = (Vertex) obj; 
          
    //     // comparing the state of argument with  
    //     // the state of 'this' Object. 
    //     return (geek.node.equals(this.node)); 
    // } 
      
      
}
public class Graph {
    private Map<String, List<Vertex>> adjacency;
    Graph(){
       adjacency = new HashMap<String, List<Vertex>>();
    };
    List<Vertex> getList(String node){
        return adjacency.get(node);
    }
    void addVertex(String node){
        adjacency.putIfAbsent(node, new ArrayList<Vertex>());
    }
    void removeVertex(String node){
        Vertex v = new Vertex(node);
        adjacency.values().stream().forEach(e -> e.remove(v));
        adjacency.remove(node);
    }
    void addEdge(String nodeA, String nodeB){
        Vertex vA = new Vertex(nodeA);
        Vertex vB = new Vertex(nodeB);
        List<Vertex> listA = adjacency.get(nodeA);
        //if the list doesnt exist, reinitialize
        if(listA == null){
            System.out.println("hi");
            listA = new ArrayList<Vertex>();
            adjacency.putIfAbsent(nodeA, listA);
        }
        listA.add(vB);
        List<Vertex> listB = adjacency.get(nodeB);
        if(listB == null){
            listB = new ArrayList<Vertex>(); 
            adjacency.putIfAbsent(nodeB, listB);
        }
        listB.add(vA);
    }
    void removeEdge(String nodeA, String nodeB){
        Vertex vA = new Vertex(nodeA);
        Vertex vB = new Vertex(nodeB);
        if(adjacency.get(nodeA)!= null){
            adjacency.get(nodeA).remove(vB);
        }
        if(adjacency.get(nodeB)!= null){
            adjacency.get(nodeB).remove(vA);
        }
    }
    void printGraph(){
        adjacency.entrySet().forEach(Entry->{
            System.out.print("\n" + Entry.getKey() + ": [");
            Entry.getValue().forEach(Node->
                System.out.print(Node.node));
                System.out.print("] ");
        });
    }
    List<Vertex> getAdjacent(String node){
        return adjacency.get(node);
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


public static void main(String[] args){
    Graph testy = new Graph();
    testy = testy.createGraph();
    testy.printGraph();
}
}
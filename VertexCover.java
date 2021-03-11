import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
public class VertexCover {
//this function serves to test a given cover to determine if it is a suitable vertex cover
    static boolean testCover(ListGraph graph, boolean[] cover){
        //cover is a boolean array representing the nodes selected by the cover
        //check that the cover array accounts for all vertices in the graph
        if(cover.length != graph.adjacency.length){
            System.out.print("Mismatched graphs");
            return false;
        }
        //make an array to match the given vertex cover
        boolean[] seen = cover;
        for(int i = 0; i< cover.length; i++){
            //if this node is not in the cover, dont test it
            if(!cover[i]) continue;
            //make an iterator for the list at this node
            Iterator<Integer> listerator = graph.adjacency[i].iterator();
            //update seen if the list at this node has an edge pointing to it
            while(listerator.hasNext()){
                Integer nextValue = listerator.next();
                seen[nextValue] = true;
            }
        }
        //if any of the nodes have not been seen, or are not included in cover, return false
        for(boolean element: seen){
            if(!element) return false;
        }
        return true;
    }
   //this function implements a brute force colution by testing every combination of k vertices to find any covers
    static boolean bruteForce(ListGraph graph, int k){
        //iterate over all subsets of size k and create covers from them
        //for each set check if it is a suitable vertex cover
        //if yes, return true then
        //check that k is not larget than the entire array
        if(k >= graph.adjacency.length) return true;
        int start = 0;
        boolean[] cover = new boolean[graph.verts];
        //iterate over top level array
        for(int i = 0; i<graph.verts; i++){
            //include index i in the cover
            cover[i] = true;
            for(int j = i+1; j< graph.verts; j++){
                //include j in the cover

                for(int m = j+1; m<graph.verts; m++){
                    
                }
            }
            //test all permutations of size k
            
            
        }


        return false;
    }
    

    static boolean[] greedyCover(ListGraph graph) {
        // initialize boolean array for all vertices; default of false
        boolean seen[] = new boolean[graph.verts];
        //iterate over the list of vertices
        for (int i = 0; i < graph.verts; i++) {
            //if this vertex has not been seen
            if (seen[i] == false) {
                //make an iterator for the adjacency lists
                Iterator<Integer> nexty = graph.adjacency[i].iterator();
                //iterate through the adjacency list
                while (nexty.hasNext()) {
                    Integer nextValue = nexty.next();
                    if (seen[nextValue] == false) {
                        seen[nextValue] = true;
                        seen[i] = true;
                        break;
                    }
                }
            }
        }
        return seen;
    }
    public static void main(String[] args){
        ListGraph graphy = new ListGraph(7);
        graphy.addEdge(0, 1);
        graphy.addEdge(0, 2);
        graphy.addEdge(1, 3);
        graphy.addEdge(3, 4);
        graphy.addEdge(4, 5);
        graphy.addEdge(5, 6);
        graphy.addEdge(2, 6);
        graphy.addEdge(4, 6);
        boolean[] cover = greedyCover(graphy);
        boolean[] testy = cover;
        testy[2] = false;
        testy[4] = false;
        testy[0] = false;
        for(int i = 0; i<cover.length; i++){
            if(cover[i]){
                System.out.print(i + " ");
        }
        }
        System.out.println(testCover(graphy, cover));
        System.out.println(testCover(graphy, testy));
    }
}

//import java.util.*;
class QuickStart{
    public static void main(String[] args){
        Graph testy = new Graph();
        testy.createGraph();
        System.out.println(testy.getAdjacent("Bob"));
    }
}
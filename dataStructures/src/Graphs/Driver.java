package Graphs;

import Graphs.ListGraph.ListGraph;
import Graphs.MapGraph.MapGraph;

public class Driver {
    public static void main(String[] args) {
       ListGraph<String> graph = new ListGraph<>();
       MapGraph<Integer> intGraph = new MapGraph<>();

       // testing add vertices
       for(int i = 18; i > 0; i-=2){
           intGraph.addVertex(i);
       }

       graph.addVertex("American");
       graph.addVertex("Belgian");
       graph.addVertex("Chinese");
       graph.addVertex("Dutch");
       graph.addVertex("European");
       graph.addVertex("Finnish");
       graph.addVertex("Greek");
       graph.addVertex("Haitian");
       graph.addVertex("Italian");

       System.out.println("------Before Creating Edges.....---------");
       printList(graph);
       printMap(intGraph);

       // testing creating edges
       intGraph.makeEdge(2,12,2);
       intGraph.makeEdge(4,14,4);
       intGraph.makeEdge(6,16,6);
       intGraph.makeEdge(8,18,8);
       intGraph.makeEdge(10,2,10);


       graph.addEdge("American", "Chinese");
       graph.addEdge("Belgian", "Dutch");
       graph.addEdge("European", "Greek");
       graph.addEdge("Finnish", "Haitian");
       graph.addEdge("Chinese", "Belgian");
       graph.addEdge("Dutch", "Italian");
        graph.addEdge("Haitian", "Finnish");
        graph.addEdge("Greek", "American");

        // testing toString method and length;
       System.out.println("---------After Creating Edges.....------------");
       printList(graph);
       printMap(intGraph);

       // testing remove edge with valid vertices and invalid vertices
       intGraph.removeEdge(10,2);
       intGraph.removeEdge(12,2);
       intGraph.removeEdge(14,2);

       graph.removeEdge("Haitian","Finnish");
       graph.removeEdge("Haitian","Fish");

       System.out.println("---------After Removing Edges.....------------");
        printList(graph);
        printMap(intGraph);

        // testing remove vertices
        graph.deleteVertex("Italian");
        graph.deleteVertex("Haitian");
        graph.deleteVertex("Greek");

        intGraph.deleteVertex(14);
        intGraph.deleteVertex(12);
        intGraph.deleteVertex(10);
        intGraph.deleteVertex(18);

        System.out.println("---------After Removing Vertices.....------------");
        printList(graph);
        printMap(intGraph);
    }

    public static void printList(ListGraph object){
        System.out.println("The list graph is: \n"+object);
        System.out.println("The number of vertices in list graph is: "
                +object.getVertexCount()+ "\n");
    }

    public static void  printMap(MapGraph object){
        System.out.println("The map graph is: \n"+ object);
        System.out.println("The number of vertices in map graph is: "
                +object.getVertexCount()+ "\n");
    }


}

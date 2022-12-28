package Graphs.ListGraph;

public class Driver {
    public static void main(String[] args) {
       ListGraph<String> graph = new ListGraph<>();
        System.out.println("Status of adding vertex a: "+graph.addVertex("a"));
        System.out.println("There are "+graph.getVertexCount()+" vertices in " +
                "graph");
    }
}

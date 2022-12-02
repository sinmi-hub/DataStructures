/*Copyright (c) 2022. Do not use without permission. All Rights Reserved.
Simi Ojeyomi*/

package GraphsTest;

// importing libraries required
import Graphs.MapWDGraph.MapWDGraph;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Collection;

// this is a test for the MapWDGraph class
public class MapWDGraphTest {

    // This tests removing edges from a graph
    @Test
    public void testRemoveEdge() {
        MapWDGraph<Character> graph= new MapWDGraph<>();
        char[] vertices = {'e', 'd', 'u', 'c'};
        char[] vertices1 = {'I', 'm','a','g'};

        // ---------creating vertices for the graph---------------
        for(char Vertex: vertices)
            graph.makeVertex(Vertex);

        for(char Vertex: vertices1)
            graph.makeVertex(Vertex);

        // ------------ creating edges for the graph--------------------
        for(int i = 0; i < 4;i++) {
            graph.makeEdge(vertices[i], vertices1[i], ((2*i)+1));
        }

        // ----------- 4 edges must be present -----------------------
        assertEquals(1, graph.edgeWeight(vertices[0], vertices1[0]));
        assertEquals(3, graph.edgeWeight(vertices[1], vertices1[1]));
        assertEquals(5, graph.edgeWeight(vertices[2], vertices1[2]));
        assertEquals(7, graph.edgeWeight(vertices[3], vertices1[3]));

        // -------------------removing 2 edges ----------------
        graph.removeEdge(vertices[2],vertices1[2]);
        graph.removeEdge(vertices[3],vertices1[3]);

        // -------------------only 2 edges must be present--------
        assertEquals(1, graph.edgeWeight(vertices[0], vertices1[0]));
        assertEquals(3, graph.edgeWeight(vertices[1], vertices1[1]));

        // -------------these 2 edges cannot be present----------
        assertEquals(-1, graph.edgeWeight(vertices[2], vertices1[2]));
        assertEquals(-1, graph.edgeWeight(vertices[3], vertices1[3]));

        //Number of Vertices in the graph should not change because edges are
        // removed
        assertEquals(8, graph.getAllVertices().size());

        // Checking if edges exist
        assertEquals(1, graph.verticesNeighbors('e').size());
        assertEquals(1, graph.verticesNeighbors('d').size());
        assertEquals(0, graph.verticesNeighbors('u').size());
        assertEquals(0, graph.verticesNeighbors('c').size());
    }

    // This test removing vertex from a graph. If vertex are removed from a
    // graph, then edges must be too. We test if one vertex is removed, or
    // both vertex are removed. Either way, the edges should not exist in graph
    @Test
    public void testRemoveVertex(){
        MapWDGraph<String> graph= new MapWDGraph<>();
        String[] vertices = {"ship", "eagle", "fat", "key", "phant",
                "mingo", "raffe", "daddy", "nana", "jug",
                "nala", "mur"};

        int j = 22;
        //----creating vertex
        for(int i = 0; i < vertices.length - 1;i++) {
            graph.makeVertex(vertices[i]);
            //--creating edge
            graph.makeEdge(vertices[i],vertices[i+1], j - 2);
        }

        // creating more edges
        graph.makeEdge(vertices[0], vertices[6], 100);
        graph.makeEdge(vertices[3], vertices[9], 200);
        graph.makeEdge(vertices[6], vertices[10], 300);
        graph.makeEdge(vertices[9], vertices[11], 400);


        // removing 1 vertex
        graph.removeVertex(vertices[7]);// removing daddy

        // checking if edges exist from any of those values
        assertEquals(-1, graph.edgeWeight("raffe", "daddy"));// no weighted edge
        assertEquals(-1, graph.edgeWeight("daddy", "nana"));

        // checking for any edges at all and seeing if daddy is a neighbor
        assertFalse(graph.verticesNeighbors("raffe").contains("daddy"));
        assertTrue(graph.getAllVertices().contains("nana"));
        assertEquals(0, graph.verticesPredecessors("nana").size());

    }

    // testing divide graph
    @Test
    public void testDivideGraph() {
        MapWDGraph<String> graph = new MapWDGraph<>();
        graph.makeVertex("A");
        graph.makeVertex("B");
        graph.makeVertex("C");
        graph.makeVertex("D");
        graph.makeVertex("E");

        graph.makeEdge("C", "D", 1);
        graph.makeEdge("B", "E", 2);
        graph.makeEdge("A", "B", 3);
        graph.makeEdge("E", "A", 4);
        graph.makeEdge("D", "D", 4);
        graph.makeEdge("A", "C", 5);
        graph.makeEdge("E", "C", 5);
        graph.makeEdge("A", "A", 6);
        graph.makeEdge("D", "C", 7);
        graph.makeEdge("C", "B", 8);
        graph.makeEdge("E", "D", 9);

        // CHECKING TO MAKE SURE TEST IS SET UP THE WAY I WANT IT
        assertEquals(3,graph.verticesNeighbors("A").size());
        assertEquals(3,graph.verticesNeighbors("E").size());
        assertEquals(2,graph.verticesNeighbors("D").size());
        assertEquals(2,graph.verticesNeighbors("C").size());
        assertEquals(1,graph.verticesNeighbors("B").size());

        // creating a collection for verticesForNewGraph
        Collection <String> verticesForNewGraph = new ArrayList<>();
        verticesForNewGraph.add("C");
        verticesForNewGraph.add("D");

        MapWDGraph<String> newGraph;
        // TESTING DIVIDE NEW GRAPH
        newGraph = graph.spiltGraph(verticesForNewGraph);

        assertEquals(3, graph.getAllVertices().size());
        assertEquals(2, newGraph.getAllVertices().size());

        //-------TESTING NEWGRAPH---------------------------
        assertEquals(1, newGraph.verticesNeighbors("C").size());
        assertEquals(2, newGraph.verticesNeighbors("D").size());
        // TESTING THE EDGECOST
        assertEquals(1, newGraph.edgeWeight("C", "D"));
        assertEquals(7, newGraph.edgeWeight("D", "C"));
        assertEquals(4, newGraph.edgeWeight("D", "D"));

        //-------TESTING CURRENT GRAPH---------------------------
        assertEquals(2, graph.verticesNeighbors("A").size());
        assertEquals(1, graph.verticesNeighbors("B").size());
        assertEquals(1, graph.verticesNeighbors("E").size());
        // TESTING THE EDGECOST
        assertEquals(6, graph.edgeWeight("A", "A"));
        assertEquals(3, graph.edgeWeight("A", "B"));
        assertEquals(2, graph.edgeWeight("B", "E"));
        assertEquals(4, graph.edgeWeight("E", "A"));
    }

    // This tests the method predecessorsOfVertices
    @Test
    public void testPredecessors() {
        MapWDGraph<String> graph= new MapWDGraph<>();
        String[] vertices = {"ship", "eagle", "fat", "key", "phant",
                "mingo", "raffe", "daddy", "nana", "jug",
                "nala", "mur"};

        int j = 22;
        //----creating vertex
        for(int i = 0; i < vertices.length - 1;i++) {
            graph.makeVertex(vertices[i]);
            //--creating edge
            graph.makeEdge(vertices[i],vertices[i+1], j - 2);
        }

        // creating more edges
        graph.makeEdge(vertices[0], vertices[6], 100);
        graph.makeEdge(vertices[3], vertices[9], 200);
        graph.makeEdge(vertices[6], vertices[10], 300);
        graph.makeEdge(vertices[9], vertices[11], 400);

        // calling adjacentVertices which contains all incoming and outgoing
        // edge
        assertEquals(2, graph.verticesNeighbors("raffe").size());
        assertEquals(2, graph.verticesPredecessors("raffe").size());

    }

    // creating an edge when there is an existing edge
    @Test
    public void testCreateExistingEdge() {
        MapWDGraph<String> graph = new MapWDGraph<>();
        graph.makeVertex("A");
        graph.makeVertex("B");
        graph.makeVertex("C");
        graph.makeVertex("D");
        graph.makeVertex("E");

        graph.makeEdge("C", "D", 1);
        graph.makeEdge("B", "E", 2);
        graph.makeEdge("A", "B", 3);
        graph.makeEdge("E", "A", 4);
        graph.makeEdge("D", "D", 4);
        graph.makeEdge("A", "C", 5);
        graph.makeEdge("E", "C", 5);
        graph.makeEdge("A", "A", 6);
        graph.makeEdge("D", "C", 7);
        graph.makeEdge("C", "B", 8);
        graph.makeEdge("E", "D", 9);

        assertTrue(graph.makeEdge("C", "D", 2));
        assertFalse(graph.makeEdge("C", "D", -2));
        assertEquals(2, graph.edgeWeight("C", "D"));
    }

    // testing events where edgeCost is invalid
    @Test
    public void testInvalidEdgeCost() {
        MapWDGraph<String> graph= new MapWDGraph<>();
        String[] vertices = {"ship", "eagle", "fat", "key", "phant",
                "mingo", "raffe", "daddy", "nana", "jug",
                "nala", "mur",};
        String[] vertices1 = {"shiper", "feagle"};

        int j = 22;
        //----creating vertex
        for(int i = 0; i < vertices.length - 1;i++) {
            graph.makeVertex(vertices[i]);
            //--creating edge
            graph.makeEdge(vertices[i],vertices[i+1], j - 2);
        }

        graph.makeVertex(vertices1[0]);
        graph.makeVertex(vertices1[1]);

        // creating more edges
        graph.makeEdge(vertices[0], vertices[6], 100);
        graph.makeEdge(vertices[3], vertices[9], 200);
        graph.makeEdge(vertices[6], vertices[10], 300);
        graph.makeEdge(vertices[9], vertices[11], 400);

        graph.removeEdge(vertices[0], vertices[6]);

        assertEquals(-1, graph.edgeWeight(vertices[0], vertices[6]));
        assertEquals(-1, graph.edgeWeight(vertices1[0], vertices1[1]));
        assertEquals(-1, graph.edgeWeight("me", "daddy"));
        assertEquals(-1, graph.edgeWeight("ship", "you"));
        assertEquals(-1, graph.edgeWeight("me", "you"));
    }

    // test removing an edge when vertices do not exist, and when vertice
    // exist but no edge
    @Test
    public void testRemoveEdge1() {
        MapWDGraph<Character> graph= new MapWDGraph<>();
        char[] vertices = {'e', 'd', 'u', 'c'};
        char[] vertices1 = {'I', 'm','a','g'};

        // ---------creating vertices for the graph---------------
        for(char Vertex: vertices)
            graph.makeVertex(Vertex);

        for(char Vertex: vertices1)
            graph.makeVertex(Vertex);
        graph.makeVertex('x');

        // ------------ creating edges for the graph--------------------
        for(int i = 0; i < 4;i++) {
            graph.makeEdge(vertices[i], vertices1[i], ((2*i)+1));
        }

        // testing remove edge when vertex does not exist
        assertFalse(graph.removeEdge('y', 'z'));
        assertFalse(graph.removeEdge('x', 'a'));
    }

    // testing null events
    @Test
    public void testNullEvents() {
        MapWDGraph<String> graph= new MapWDGraph<>();
        String[] vertices = {"ship", "eagle", "fat", "key", "phant",
                "mingo", "raffe", "daddy", "nana", "jug",
                "nala", "mur"};

        int j = 22;
        //----creating vertex
        for(int i = 0; i < vertices.length - 1;i++) {
            graph.makeVertex(vertices[i]);
            //--creating edge
            graph.makeEdge(vertices[i],vertices[i+1], j - 2);
        }

        // creating more edges
        graph.makeEdge(vertices[0], vertices[6], 100);
        graph.makeEdge(vertices[3], vertices[9], 200);
        graph.makeEdge(vertices[6], vertices[10], 300);
        graph.makeEdge(vertices[9], vertices[11], 400);
        assertThrows(IllegalArgumentException.class,
                () -> {
            graph.verticesNeighbors(null);
            graph.makeEdge(null, "daddy", j);
            graph.makeVertex(null);
            assertNull(graph.spiltGraph(null));
            graph.edgeWeight("ship", null);
            graph.edgeWeight(null, "raffe");
            graph.findVertex(null);
            graph.verticesPredecessors(null);
            graph.removeEdge(null, "nana");
            graph.removeEdge("jug", null);
            graph.removeVertex(null);
                });

    }
}
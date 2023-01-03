package GraphsTest;

/*This class contains test for the ListGraph class. Most of the test I write
do not have comments. My apologies*/

import org.junit.jupiter.api.Test;
import Graphs.ListGraph.ListGraph;
import static org.junit.jupiter.api.Assertions.*;

class ListGraphTest {

    @Test
    void testAddVertex() {
        ListGraph<Character> graph= new ListGraph<>();
        char[] vertices = {'e', 'd', 'u', 'c'};
        char[] vertices1 = {'I', 'm','a','g'};

        // ---------creating vertices for the graph---------------
        for(char Vertex: vertices)
            graph.addVertex(Vertex);

        for(char Vertex: vertices1)
            graph.addVertex(Vertex);

        assertEquals(8,graph.getVertexCount());
        graph.clear();

        // checking to see if vertex can be added after clearing
        for(char Vertex: vertices)
            graph.addVertex(Vertex);

        for(char Vertex: vertices1)
            graph.addVertex(Vertex);

        // checking the number of vertices that are currently in graph object
        assertEquals(8,graph.getVertexCount());

    }

    @Test
    void testDeleteVertex() {
        ListGraph<String> graph = new ListGraph<>();

        String[] vertices = {"ship", "eagle", "fat", "key", "phant",
                "mingo", "raffe", "daddy", "nana", "jug",
                "nala", "mur"};

        // removing a vertex that does not exist
        assertFalse(graph.deleteVertex("Hp"));

        // adding vertex to graph
        for (String vertex : vertices)
            graph.addVertex(vertex);

        // checking the number of vertices that are currently in graph object
        assertEquals(vertices.length, graph.getVertexCount());

        // removing vertex from graph and checking number of vertex until graph
        // is empty
        assertTrue(graph.deleteVertex("jug"));
        assertEquals(vertices.length -1, graph.getVertexCount());

        assertTrue(graph.deleteVertex("ship"));
        assertTrue(graph.deleteVertex("eagle"));
        assertEquals(vertices.length - 3, graph.getVertexCount());


        for(int i = 2; i < 9; i++)
            assertTrue(graph.deleteVertex(vertices[i]));

        assertTrue(graph.deleteVertex("nala"));
        assertTrue(graph.deleteVertex("mur"));

        assertEquals(0, graph.getVertexCount());

    }

    @Test
    void testGetVertexCount() {
        ListGraph<Character> graph = new ListGraph<>();
        // adding vertices
        for(char i = 'a'; i <= 'j'; i++)
            graph.addVertex(i);

        // checking the number of vertices that are currently in graph object
        assertEquals(10, graph.getVertexCount());

        //removing all vertices
        for(char i = 'a'; i <= 'e'; i++)
            graph.deleteVertex(i);

        assertEquals(5 ,graph.getVertexCount());

        graph.clear();// completely clears graph of all vertices and object

        // adding again and removing  to check that vertex can be added after
        // graph is cleared
        for(char i = 'a'; i <= 'z'; i++)
            graph.addVertex(i);

        assertEquals(26 ,graph.getVertexCount());

        for(char i = 'a'; i <= 'z'; i++)
            graph.deleteVertex(i);

        assertEquals(0 ,graph.getVertexCount());
    }

    @Test
    void testFindVertex() {
        ListGraph<String> graph = new ListGraph<>();

        String[] vertices = {"ship", "eagle", "fat", "key", "phant",
                "mingo", "raffe", "daddy", "nana", "jug",
                "nala", "mur"};

        // adding vertices
        for(String s: vertices)
            graph.addVertex(s);

        // verifying that those vertices exit in graph
        for(String s: vertices)
            assertTrue(graph.findVertex(s));

        // checking for vertices that SHOULD NOT exist in graph
        assertFalse(graph.findVertex("do not copy blindly, learn"));
        assertFalse(graph.findVertex(""));
    }

    @Test
    void testVerticesNeighbors() {
        ListGraph<String> streaming = new ListGraph<>();

        // adding vertices
        streaming.addVertex("Netflix");
        streaming.addVertex("Disney");
        streaming.addVertex("Hulu");
        streaming.addVertex("123Movies");
        streaming.addVertex("Peacock");
        streaming.addVertex("HBOMax");
        streaming.addVertex("Prime Video");
        streaming.addVertex("Crunchy-roll");

        // remember add edge will create the vertices, even if they did not
        // exist previously
        streaming.addEdge("American", "Chinese");
        streaming.addEdge("Belgian", "Dutch");
        streaming.addEdge("European", "Greek");
        streaming.addEdge("Finnish", "Haitian");
        streaming.addEdge("Chinese", "Belgian");
        streaming.addEdge("Dutch", "Italian");
        streaming.addEdge("Haitian", "Finnish");

        // creating edges with already existing vertices
        streaming.addEdge("Netflix", "HBOMax");
        streaming.addEdge("HBOMax", "Disney");
        streaming.addEdge("Peacock", "Hulu");
        streaming.addEdge("Disney", "Netflix");
        streaming.addEdge("Prime Video", "Crunchy-roll");
        streaming.addEdge("123Movies", "Peacock");
        streaming.addEdge("Crunchy-roll", "123Movies");
        streaming.addEdge("Prime Video", "Prime Video");

        // test for existing vertices with 2 neighbors
        assertEquals("[Crunchy-roll, Prime Video]",
                streaming.verticesNeighbors("Prime Video").toString());

        //testing for vertex that does not exist
        assertNull(streaming.verticesNeighbors("PlutoTV"));

        // testing for vertex that exist, but has no neighbors
        assertEquals("[]",
                streaming.verticesNeighbors("Greek").toString());
    }

    @Test
    void testRemoveEdge() {
        ListGraph<String> cities = new ListGraph<>();
        cities.addVertex("Los Angeles");
        cities.addVertex("Boston");
        cities.addVertex("Houston");
        cities.addVertex("Orlando");

        // creating edges to exist
        cities.addEdge("Orlando", "Florida");
        cities.addEdge("Boston", "Massachusetts");
        cities.addEdge("Houston", "Texas");
        cities.addEdge("Los Angeles", "California");

        // checking number of edges present
        assertEquals(4, cities.getEdgesCount());

        // using neighbors to check for edges that a particular vertex has
        assertEquals("[Florida]",
                cities.verticesNeighbors("Orlando").toString());
        assertEquals("[Massachusetts]",
                cities.verticesNeighbors("Boston").toString());
        assertEquals("[Texas]",
                cities.verticesNeighbors("Houston").toString());
        assertEquals("[California]",
                cities.verticesNeighbors("Los Angeles").toString());
        
        // removing all edges present
        cities.removeEdge("Orlando", "Florida");
        cities.removeEdge("Boston", "Massachusetts");
        cities.removeEdge("Houston", "Texas");
        cities.removeEdge("Los Angeles", "California");

        // using neighbors to check for edges that a particular vertex has
        assertEquals("[]",
                cities.verticesNeighbors("Orlando").toString());
        assertEquals("[]",
                cities.verticesNeighbors("Boston").toString());
        assertEquals("[]",
                cities.verticesNeighbors("Houston").toString());
        assertEquals("[]",
                cities.verticesNeighbors("Los Angeles").toString());

        // checking number of edges present
        assertEquals(0, cities.getEdgesCount());
    }

    @Test
    void testPredecessors() {
        ListGraph<String> culture = new ListGraph<>();

        culture.addVertex("Mongolian");

        culture.addEdge("American", "Chinese");
        culture.addEdge("Belgian", "Dutch");
        culture.addEdge("European", "Greek");
        culture.addEdge("Finnish", "Haitian");
        culture.addEdge("Chinese", "Belgian");
        culture.addEdge("Dutch", "Italian");
        culture.addEdge("Haitian", "Finnish");

        // if edge is already present, how does it behave?
        culture.addEdge("American", "Chinese");
        culture.addEdge("Belgian", "Dutch");
        culture.addEdge("European", "Greek");
        culture.addEdge("Finnish", "Haitian");
        culture.addEdge("Chinese", "Belgian");
        culture.addEdge("Dutch", "Italian");
        culture.addEdge("Haitian", "Finnish");

        // creating more edges
        culture.addEdge("Chinese", "Greek");
        culture.addEdge("Belgian", "Finnish");
        culture.addEdge("American", "Finnish");

        assertEquals(10, culture.getEdgesCount());

        // getting predecessor of existing vertex that has edges
        assertEquals(3,culture.predecessors("Finnish").size());
        assertEquals("[American, Belgian, Haitian]",
                culture.predecessors("Finnish").toString());

        // getting predecessor of Non-existing vertex
        assertNull(culture.predecessors("Eskimo"));

        // getting predecessor of existing vertex that has NO edges
        assertEquals(0,culture.predecessors("Mongolian").size());
    }

    @Test
    public void testNullEvents(){
        ListGraph<String> graph = new ListGraph<>();

        // testing what should happen if null or invalid input are passed
       assertThrows(IllegalArgumentException.class , () -> {
           graph.addVertex(null);
           graph.addEdge("Valid" , null);
           graph.addEdge(null, "GoodVertex");
           graph.deleteVertex(null);
           assertEquals(0, graph.getEdgesCount());
           assertEquals(0, graph.getVertexCount());
           graph.findVertex(null);
           graph.removeEdge("Valid" , null);
           graph.removeEdge(null, "GoodVertex");
           graph.predecessors(null);
           graph.verticesNeighbors(null);
        });
    }

}
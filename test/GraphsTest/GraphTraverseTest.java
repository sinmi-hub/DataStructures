package GraphsTest;

import Graphs.GraphTraversals.GraphTraverse;
import Graphs.ListGraph.ListGraph;
import Graphs.MapGraph.MapGraph;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class GraphTraverseTest {
    GraphTraverse<Character> traverse = new GraphTraverse<>();

    @Test
    void BFS() {
        MapGraph<Character> alphabet = new MapGraph<>();
        ListGraph<Character> listGraph = new ListGraph<>();

        for(char i = 'A'; i <= 'H';i++){
            alphabet.addVertex(i);
            if(i < 'H'){
                listGraph.addVertex(i);
            }
        }

        // checking to see that all the vertex were added properly
        assertEquals(8,alphabet.getVertexCount());
        assertEquals(7,listGraph.getVertexCount());

        // creating edges in each graph, starting with mapGraph
        alphabet.makeEdge('A','B', 1);
        alphabet.makeEdge('A','E', 8);
        alphabet.makeEdge('B','C', 2);
        alphabet.makeEdge('B','E', 5);
        alphabet.makeEdge('C','F', 3);
        alphabet.makeEdge('C','H', 6);
        alphabet.makeEdge('D','G', 9);
        alphabet.makeEdge('E','C', 4);
        alphabet.makeEdge('E','D', 7);
        alphabet.makeEdge('E','F', 3);
        alphabet.makeEdge('E','G', 5);
        alphabet.makeEdge('F','G', 8);
        alphabet.makeEdge('G','H', 6);
        alphabet.makeEdge('H','F', 1);

        // creating edges in the list graph
        listGraph.addEdge('A','B');
        listGraph.addEdge('B','C');
        listGraph.addEdge('B','D');
        listGraph.addEdge('B','E');
        listGraph.addEdge('C','F');
        listGraph.addEdge('C','G');
        listGraph.addEdge('D','E');
        listGraph.addEdge('D','G');
        listGraph.addEdge('E','B');
        listGraph.addEdge('E','C');
        listGraph.addEdge('E','F');

        // Traversing
        Collection<Character> bfsIteration =
                                    traverse.BFS(alphabet, 'A');

        // testing what the bfs iteration should look like on alphabets
        assertEquals(8,bfsIteration.size());
        assertEquals("[A, B, E, C, D, F, G, H]",
                                    bfsIteration.toString());

        // testing what bfsIteration should look like on list graph
        Collection<Character> bfsIteration1 =
                traverse.BFS(listGraph, 'A');
        assertEquals(7,bfsIteration1.size());
        assertEquals("[A, B, C, D, E, F, G]",
                bfsIteration1.toString());

    }

    @Test
    void iterativeDFS() {
        MapGraph<Character> mapGraph = new MapGraph<>();

        //adding vertices
        for(char i = 'A'; i <= 'H';i++)
            mapGraph.addVertex(i);


        // creating edges in each graph, starting with mapGraph
        mapGraph.makeEdge('A','B', 1);
        mapGraph.makeEdge('A','E', 8);
        mapGraph.makeEdge('B','C', 2);
        mapGraph.makeEdge('B','E', 5);
        mapGraph.makeEdge('C','F', 3);
        mapGraph.makeEdge('C','H', 6);
        mapGraph.makeEdge('D','G', 9);
        mapGraph.makeEdge('E','C', 4);
        mapGraph.makeEdge('E','D', 7);
        mapGraph.makeEdge('E','F', 3);
        mapGraph.makeEdge('E','G', 5);
        mapGraph.makeEdge('F','G', 8);
        mapGraph.makeEdge('G','H', 6);
        mapGraph.makeEdge('H','F', 1);


        Collection<Character> dfsMapGraph =
                traverse.iterativeDFS(mapGraph, 'A');
        assertEquals(8,dfsMapGraph.size());
        assertEquals("[A, E, G, H, F, D, C, B]",
                dfsMapGraph.toString());
    }

    @Test
    void recursiveDFS() {
        MapGraph<Character> mapGraph = new MapGraph<>();
        ListGraph<Character> listGraph = new ListGraph<>();
        
        //adding vertices
        for(char i = 'A'; i <= 'H';i++){
            mapGraph.addVertex(i);
            if(i < 'H'){
                listGraph.addVertex(i);
            }
        }

        // checking to see that all the vertex were added properly
        assertEquals(8,mapGraph.getVertexCount());
        assertEquals(7,listGraph.getVertexCount());

        // creating edges in each graph, starting with mapGraph
        mapGraph.makeEdge('A','B', 1);
        mapGraph.makeEdge('A','E', 8);
        mapGraph.makeEdge('B','C', 2);
        mapGraph.makeEdge('B','E', 5);
        mapGraph.makeEdge('C','F', 3);
        mapGraph.makeEdge('C','H', 6);
        mapGraph.makeEdge('D','G', 9);
        mapGraph.makeEdge('E','C', 4);
        mapGraph.makeEdge('E','D', 7);
        mapGraph.makeEdge('E','F', 3);
        mapGraph.makeEdge('E','G', 5);
        mapGraph.makeEdge('F','G', 8);
        mapGraph.makeEdge('G','H', 6);
        mapGraph.makeEdge('H','F', 1);

        // creating edges in the list graph
        listGraph.addEdge('A','B');
        listGraph.addEdge('B','C');
        listGraph.addEdge('B','D');
        listGraph.addEdge('B','E');
        listGraph.addEdge('C','F');
        listGraph.addEdge('C','G');
        listGraph.addEdge('D','E');
        listGraph.addEdge('D','G');
        listGraph.addEdge('E','B');
        listGraph.addEdge('E','C');
        listGraph.addEdge('E','F');

        //traversing
        Collection<Character> dfsRecurMapGraph =
                traverse.recursiveDFS(mapGraph, 'A');
        assertEquals(8,dfsRecurMapGraph.size());
        assertEquals("[A, B, C, F, G, H, E, D]",
                dfsRecurMapGraph.toString());

        // Traversing
        Collection<Character> dfsRecurListGraph =
                traverse.recursiveDFS(listGraph,'A');
        assertEquals(7,dfsRecurListGraph.size());
        assertEquals("[A, B, C, F, G, D, E]",
                dfsRecurListGraph.toString());
    }
}
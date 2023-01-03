package Graphs.GraphTraversals;

/*This class is a class that represents algorithms for graph traversals. These
algorithms include Breadth-First Traversals(bfs), Recursive Depth First
Traversals and iterative depth first traversals. Each of these algorithms
use peculiar data structures to process vertices in a graph in a certain order.
It is important to note that the vertices are processed in the order that
they are stored in the graph. LinkedList object is also used in this class
because LinkedList implements the queue interface. A linked hash set is also
used to store the order in which the vertices are processed*/


import Graphs.*;
import java.util.Collection;
import java.util.Queue;
import java.util.LinkedHashSet;
import java.util.Stack;
import java.util.LinkedList;

public class GraphTraverse<V> {
//TODO possible optimizations

    /**This method process the vertices of a graph object using a breadth
     * first algorithm. The BFS algorithm traverses the vertices of a graph
     * in a breadth-ward motion. In other words, it starts the graph traversal
     * from a specific vertex and explores all the neighboring vertex first
     * instead of going deep or downwards. Using this algorithm, neighboring
     * vertices are traversed first.
     *
     * @param object (Current graph object to process)
     * @param startVertex (Vertex to start from)
     * @return Collection of vertices in the graph object processed breadth
     *          first
     */
    public Collection<V> BFS(Graphs<V> object, V startVertex){
        V vertexProcessing;
        Queue<V> visited = new LinkedList<>();// processes node visited
        // tracks vertices visited
        LinkedHashSet<V> trackVisited = new LinkedHashSet<>();

        // checking if object and start vertex are valid graph objects
        if(object == null || startVertex == null)
            throw new IllegalArgumentException("Invalid parameter found");

        /* checking if starting vertex is actually a valid vertex in the
         graph object*/
        if(object.findVertex(startVertex)){
            //Enqueue start vertex
            visited.add(startVertex);

            //Dequeue the vertex and process it neighbors
            while (!visited.isEmpty()){
                // vertex that is currently being processed in while loop
                vertexProcessing = visited.peek();
                //Dequeue the vertex
                visited.remove();
                // getting the neighbors of the start vertex
                Collection<V> neighbors = 
                        object.verticesNeighbors(vertexProcessing);
                // mark the vertex processed as visited
                trackVisited.add(vertexProcessing);

                // Enqueue all unvisited neighbors
                for(V vertex: neighbors){

                    // checks if vertex is not in set
                    if(!trackVisited.contains(vertex))
                        visited.add(vertex);// enqueues unvisited neighbors
                }
            }
        }


        return trackVisited;
    }

    /**This method uses the depth first search algorithm to process the
     * vertices of the current graph object. This algorithm starts at a
     * specific vertex and explore as far as possible along each branch
     * downwards before backtracking. In order words, not all neighboring
     * vertices of a specific vertex are processed immediately. i.e. for a
     * vertex 'A' that has neighbors 'B' and 'C'. Unlike bfs that processes
     * 'B' and 'C' in that order, iterative DFS processes 'B' first and all
     * its neighbors, till it finds none, then backtracks to process 'C' and
     * all its neighbors
     *
     * @param object  (Current graph object to process)
     * @param startVertex (Vertex to start from)
     * @return Collection of vertices in the graph object processed breadth
     *        first
     */
    public Collection<V> iterativeDFS(Graphs<V> object, V startVertex){
        // using the stack structure to process the graph, depth first
        Stack<V> stack = new Stack<>();
        // stores the nodes that have been visited
        LinkedHashSet<V> visited = new LinkedHashSet<>();

        // checking if object and start vertex are valid graph objects
        if(object == null || startVertex == null)
            throw new IllegalArgumentException("Invalid parameter found");

        // check to see if startVertex exist in object graph
        if(object.findVertex(startVertex)){
            stack.push(startVertex);// pushes the vertex onto the stack

            while (!stack.isEmpty()) {
                /* gets the vertex at the top of stack, which is the vertex
                 being processed*/
                V currVertex = stack.peek();
                // remove the top vertex from the stack i.e. currVertex
                stack.pop();
                // store the vertex as visited
                visited.add(currVertex);
                // get neighbors of vertex being processed
                Collection<V> vertexNeighbors =
                        object.verticesNeighbors(currVertex);

                // process the neighbors
                for (V vertex : vertexNeighbors) {

                    // only process vertices that have not been visited
                    if (!visited.contains(vertex))
                        stack.push(vertex);// pushes onto stack to process
                }
            }
        }

        return visited;
    }

    /**This method is also a DFS algorithm. But instead of an iterative
     * implementation, it simply uses recursion
     *
     * @param object (Current graph object to process)
     * @param startVertex (Vertex to start from)
     * @return Collection of vertices in the graph object processed breadth
     *         first
     */
    public Collection<V> recursiveDFS(Graphs<V> object, V startVertex) {
        // to store vertices that are visited
        LinkedHashSet<V> visited = new LinkedHashSet<>();

        // checking if object and start vertex are valid graph objects
        if (object == null || startVertex == null)
            throw new IllegalArgumentException("Invalid parameter found");

        // checking to see if startVertex is in the current graph object
        if(object.findVertex(startVertex))
        {
            // recursively processes graph
           dfsHelper(startVertex,object,visited);
        }

        return visited;
    }

    /**This is a private method that serves as a helper method for the
     * recursive dfs implementation. It takes three parameters, startVertex,
     * which is the vertex that is being processed at any time, the graph
     * object, and the set that represents vertices that have been visited.
     *
     * @param startVertex (Current vertex being processed recursively)
     * @param object (Current graph object to process)
     * @param visited (represents a set that contains processed vertices)
     */
    private void dfsHelper(V startVertex, Graphs<V> object,
                           LinkedHashSet<V> visited){
        // adds the starting vertex to the visited set
        visited.add(startVertex);
        // gets the neighbors of the vertex in question. i.e. start vertex
        Collection<V> startVertxNeighbor = object.verticesNeighbors(startVertex);

        // Iterates through all adjacent vertices of start vertex
        for(V vertex: startVertxNeighbor){

            // recursively process vertices that have nor been visited in
            // 'startVertex' neighbors
            if(!visited.contains(vertex))
                dfsHelper(vertex, object, visited);
        }

    }
}

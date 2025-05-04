import java.io.*;
import java.util.*;

class FindingBridges {
    private int vertices; // Number of vertices
    private LinkedList<Integer> adjacencyList[]; // Array of lists for Adjacency List Representation
    int time = 0;

    // Constructor
    FindingBridges(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; ++i)
            adjacencyList[i] = new LinkedList<>();
    }

    // Function to add an edge into the graph
    void addEdge(int vertex1, int vertex2) {
        adjacencyList[vertex1].add(vertex2); // Add vertex2 to vertex1's list.
        adjacencyList[vertex2].add(vertex1); // Add vertex1 to vertex2's list
    }

    // A recursive function that finds and prints bridges using DFS traversal
    void bridgeUtil(int currentVertex, boolean visited[], int discoveryTime[], int lowestDiscoveryTime[], int parentVertex[]) {
        // Mark the current node as visited
        visited[currentVertex] = true;
        System.out.println("bridgeUtil currentVertex " + currentVertex + " parentVertex " + Arrays.toString(parentVertex));

        // Initialize discovery time and low value
        discoveryTime[currentVertex] = lowestDiscoveryTime[currentVertex] = ++time;

        // Go through all vertices adjacent to this
        Iterator<Integer> iterator = adjacencyList[currentVertex].iterator();
        while (iterator.hasNext()) {
            int adjacentVertex = iterator.next(); // adjacentVertex is current adjacent of currentVertex
            System.out.println("currentVertex " + currentVertex + " adjacentVertex " + adjacentVertex + " visited[adjacentVertex] " + visited[adjacentVertex]);

            // If adjacentVertex is not visited yet, then make it a child of currentVertex in DFS tree and recur for it.
            if (!visited[adjacentVertex]) {
                parentVertex[adjacentVertex] = currentVertex;
                bridgeUtil(adjacentVertex, visited, discoveryTime, lowestDiscoveryTime, parentVertex);

                // Check if the subtree rooted with adjacentVertex has a connection to one of the ancestors of currentVertex
                lowestDiscoveryTime[currentVertex] = Math.min(lowestDiscoveryTime[currentVertex], lowestDiscoveryTime[adjacentVertex]);

                System.out.println("currentVertex " + currentVertex + " adjacentVertex " + adjacentVertex + " lowestDiscoveryTime " +
                        Arrays.toString(lowestDiscoveryTime) + " discoveryTime " + Arrays.toString(discoveryTime));

                // If the lowest vertex reachable from subtree under adjacentVertex is below currentVertex in DFS tree,
                // then currentVertex-adjacentVertex is a bridge
                if (lowestDiscoveryTime[adjacentVertex] > discoveryTime[currentVertex])
                    System.out.println(currentVertex + " " + adjacentVertex);
            }
            // Update low value of currentVertex for parent function calls.
            else if (adjacentVertex != parentVertex[currentVertex])
                lowestDiscoveryTime[currentVertex] = Math.min(lowestDiscoveryTime[currentVertex], discoveryTime[adjacentVertex]);
        }
    }

    // DFS based function to find all bridges. It is recursive
    void findBridges() {
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[vertices];
        int discoveryTime[] = new int[vertices];
        int lowestDiscoveryTime[] = new int[vertices];
        int parentVertex[] = new int[vertices];

        // Initialize parent and visited arrays
        for (int i = 0; i < vertices; i++) {
            parentVertex[i] = -1;
            visited[i] = false;
        }

        // Call the recursive helper function to find Bridges in DFS tree rooted with vertex 'i'
        for (int i = 0; i < vertices; i++) 
            if (!visited[i])
                bridgeUtil(i, visited, discoveryTime, lowestDiscoveryTime, parentVertex);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int vertices = scanner.nextInt();
        int edges = scanner.nextInt();

        FindingBridges graph = new FindingBridges(vertices);
        for (int i = 0; i < edges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            graph.addEdge(vertex1, vertex2);
        }
        System.out.println("Bridges in graph");
        graph.findBridges();
    }
}

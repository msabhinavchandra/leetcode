import java.util.*;

class FindingBridges {
    private int numberOfVertices;
    private List<List<Integer>> adjacencyList;
    private int time;

    // Constructor
    FindingBridges(int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < numberOfVertices; ++i)
            adjacencyList.add(new ArrayList<>());
        time = 0;
    }

    // Function to add an edge into the graph
    void addEdge(int vertex1, int vertex2) {
        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);
    }

    // A recursive function that finds and prints bridges using DFS traversal
    void findBridgesUtil(int currentVertex, boolean[] visited, int[] discoveryTime, int[] lowestDiscoveryTime,
            int[] parentVertex) {
        visited[currentVertex] = true;
        discoveryTime[currentVertex] = lowestDiscoveryTime[currentVertex] = ++time;

        for (int adjacentVertex : adjacencyList.get(currentVertex)) {
            if (!visited[adjacentVertex]) {
                parentVertex[adjacentVertex] = currentVertex;
                findBridgesUtil(adjacentVertex, visited, discoveryTime, lowestDiscoveryTime, parentVertex);

                lowestDiscoveryTime[currentVertex] = Math.min(lowestDiscoveryTime[currentVertex],
                        lowestDiscoveryTime[adjacentVertex]);

                if (lowestDiscoveryTime[adjacentVertex] > discoveryTime[currentVertex]) {
                    System.out.println(currentVertex + " " + adjacentVertex);
                }
            } else if (adjacentVertex != parentVertex[currentVertex]) {
                lowestDiscoveryTime[currentVertex] = Math.min(lowestDiscoveryTime[currentVertex],
                        discoveryTime[adjacentVertex]);
            }
        }
    }

    // DFS based function to find all bridges
    void findBridges() { 
        boolean[] visited = new boolean[numberOfVertices];
        int[] discoveryTime = new int[numberOfVertices];
        int[] lowestDiscoveryTime = new int[numberOfVertices];
        int[] parentVertex = new int[numberOfVertices];

        Arrays.fill(parentVertex, -1);

        for (int i = 0; i < numberOfVertices; i++) {
            if (!visited[i]) {
                findBridgesUtil(i, visited, discoveryTime, lowestDiscoveryTime, parentVertex);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfVertices = scanner.nextInt();
        int numberOfEdges = scanner.nextInt();

        FindingBridges graph = new FindingBridges(numberOfVertices);
        for (int i = 0; i < numberOfEdges; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            graph.addEdge(vertex1, vertex2);
        }
        System.out.println("Bridges in graph");
        graph.findBridges();
    }
}

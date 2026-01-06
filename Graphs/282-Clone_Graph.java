// Abhinav and Neetcode


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
import java.util.*;

class Solution2 {
    HashMap<Node, Node> map;

    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        Node newnode = func(node);
        return newnode;

    }

    public Node func(Node node) {
        // if copy exists
        if (node == null)
            return null;
        int n = node.val;
        Node newnode = new Node(n);//calling only for 
        map.put(node, newnode);

        for (Node ngbr : node.neighbors) {
            if (map.containsKey(ngbr)) {// if alr created
                newnode.neighbors.add(map.get(ngbr));
            }
            // if uncreated
            else {
                // newnode.neighbors.add(map.get(ngbr));
                func(ngbr);
                newnode.neighbors.add(map.get(ngbr));

            }

        }
        return newnode;
    }
    // return newnode;

}
// time complexity O(N+E) each node and edge is visited once
// space complexity O(N) hashmap and recursion stack

//Reason: Each node is visited once and each edge is traversed once while 
// iterating through neighbors.
/*  Because we use a HashMap to avoid revisiting nodes, each node is cloned only 
once.
And when cloning a node, we iterate through all its neighbors, so across the graph
every edge is processed once. */



// import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        // hashmap to keep track of all cloned nodes
        Map<Node, Node> map = new HashMap<>();

        // queue to perform a bfs
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);
        map.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            Node currClone = map.get(curr);

            for (Node neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    // clone the neighbor node and add it to map

                    map.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }

                currClone.neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);

    }
}

// what if i just copy the neigbours and return, once try it that way too